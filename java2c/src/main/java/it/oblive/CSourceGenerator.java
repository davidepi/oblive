package it.oblive;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.AntidebugTime;
import it.oblive.support.ExtractedBytecode;
import it.oblive.support.JniType;
import it.oblive.support.MethodSignature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class creates the C source file starting from the output of the MethodBytecodeExtractor.
 *
 * @author D.Pizzolotto
 */
public class CSourceGenerator {

    private ArrayList<String> headers;
    private ArrayList<String> defines;
    private ArrayList<String> methods;

    public CSourceGenerator() {
        this.headers = new ArrayList<>();
        this.defines = new ArrayList<>();
        this.methods = new ArrayList<>();
    }

    /**
     * Get the content of a resource file as String
     *
     * @param filename Name of the INPUT file. Must be in the resources.
     */
    public String getResources(@NotNull final String filename) {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(filename);
        assert stream != null;
        return new BufferedReader(new InputStreamReader(stream))
                .lines().collect(Collectors.joining("\n"));
    }

    /**
     * Append a C header file passed as string
     *
     * @param content The actual content of the header that should be appended
     */
    public void addHeader(@NotNull final String content) {
        headers.add(content);
    }

    /**
     * Add a global define on top of the C file
     *
     * @param name  name of the define, without the #define keyword
     * @param value value of the define
     */
    public void addGlobalDefine(@NotNull final String name, @Nullable String value) {
        if (value == null) {
            defines.add("#define " + name);
        } else {
            defines.add("#define " + value);
        }
    }

    /**
     * This method transforms the ExtractedBytecode resulting from a MethodBytecodeExtractor into a C method,
     * performing also the method name mangling.
     *
     * @param className    name of the class owning the native method
     * @param methodName   name of the native method
     * @param signature    signature of the native method
     * @param eb           result of the MethodBytecodeExtractor
     * @param overloaded   true if other methods within the same class and with the same name exists.
     * @param obfuscations a set containing the Class for every obfuscation requested.
     * @param libname      The name of the generated library. Used for invoking the second process in the self-debugging
     */
    public void addNativeMethod(@NotNull String className, @NotNull String methodName,
                                @NotNull MethodSignature signature,
                                @NotNull ExtractedBytecode eb, boolean overloaded, @NotNull HashSet<Class> obfuscations,
                                @NotNull String libname) {
        StringBuilder sb = new StringBuilder();
        boolean antidebugTime = obfuscations.contains(AntidebugTime.class);
        boolean antidebugSelf = obfuscations.contains(AntidebugSelf.class);

        //if the function is void, the exception should not return 0, but just return
        if (signature.getReturnType().getJniName().equals("void")) {
            sb.append("#define RETURN_EXCEPTION goto exitpoint;\n");
        } else {
            sb.append("#define RETURN_EXCEPTION __return_retval__.i = 0;goto exitpoint;\n");
        }

        //generate JNI signature
        sb.append("JNIEXPORT ");
        sb.append(signature.getReturnType().getJniName());
        if (signature.getReturnType().getArrayDepth() > 0) {
            sb.append("Array");
        }
        sb.append(" JNICALL ");
        sb.append(mangleCMethodName(className, methodName, overloaded, signature));
        sb.append("(JNIEnv* env, ");
        if (!eb.isStatic) {
            sb.append("jobject this");
        } else {
            sb.append("jclass staticClass");
        }
        for (int i = 0; i < signature.getInput().size(); i++) {
            sb.append(", ");
            sb.append(signature.getInput().get(i).getJniName());
            sb.append(" ");
            sb.append("var");
            sb.append(i + 1); //since var0 is called `this`
        }
        sb.append(")\n");
        sb.append("{\n");

        /* ----------------------------- FUNCTION BODY STARTS HERE ---------------------------------------------------*/
        sb.append("calls++;\n");
        //antidebug techniques
        if (antidebugTime || antidebugSelf) {
            sb.append("if(child==0)break_java_debugger();\n");
            if (antidebugTime) {
                sb.append("time_t debug_timer;\n");
                sb.append("time_start(&debug_timer);\n");
            }
            if (antidebugSelf) {
                sb.append("if(child==0){\n"); //recursive calls won't apply selfdebug (or they will fail to attach)
                sb.append("child = self_debug(env, \"").append(libname).append("vm.o\");\n");
                sb.append("if(!child)return 0;\n");
                sb.append("}\n");
            }
        }

        //generate stack vars
        sb.append("generic_t __return_retval__;\n");
        if (antidebugSelf) {
            sb.append("generic_t stack_size;\n");
            sb.append("stack_size.i = ");
            sb.append(eb.maxStack);
            sb.append(";\n");
            sb.append("run_command_params(child, STACK, stack_size);\n");
            //generate anyway the vars _stack and _index, even though they won't be used
            sb.append("uint32_t _index = 0;\n");
            sb.append("generic_t* _stack = NULL;\n");
        } else {
            sb.append("uint32_t _index = 0;\n");
            sb.append("generic_t _stack[");
            sb.append(eb.maxStack);
            sb.append("];\n");
        }
        sb.append("generic_t _vars[");
        sb.append(eb.maxLVar);
        sb.append("];\n");

        //avoid having garbage values if bytes/shorts/booleans/chars are passed, since int will be returned
        sb.append("memset(_vars,0,sizeof(_vars));\n");
        sb.append("jclass exception = NULL;\n");
        sb.append("char retcode = 0;\n"); //used by some methods to check if some exceptions were raised

        //push arguments into local vars
        int vars_index = 0; //vars_index, could differ from actual operands index because of static functions or
        // double words;
        if (!eb.isStatic) {
            sb.append("_vars[0].l=this;\n"); //this pointer is pushed only if the class is not static
            vars_index++;
        }
        for (int i = 0; i < signature.getInput().size(); i++) {
            JniType currentType = signature.getInput().get(i);
            sb.append("_vars[");
            sb.append(vars_index++);
            sb.append("].");
            sb.append(currentType.getJvalueLetter());
            sb.append("=var");
            sb.append(i + 1);
            sb.append(";\n");
            if (currentType.isDoubleLength()) {
                vars_index++;
            }
        }
        sb.append('\n');

        //push statements
        for (int i = 0; i < eb.statements.size(); i++) {
            String str = eb.statements.get(i);
            if (str.length() > 0) {
                sb.append(str);
                if (str.charAt(str.length() - 1) != '\n') {
                    sb.append('\n');
                }
            }
        }
        sb.append("exitpoint:\n");
        /* --------------------------------- FUNCTION CLEANUP HERE ---------------------------------------------------*/
        if (antidebugTime) {
            sb.append("time_check(&debug_timer);\n");
        }
        if (antidebugSelf) {
            sb.append("run_command(child, KILL);\n");
            sb.append("calls--;\n");
            sb.append("if(calls==0){\n");
            sb.append("waitpid(child_pid_h, NULL, 0);\n");
            sb.append("close(child);child=0;}\n");
        }
        /* --------------------------------------- END OF FUNCTION ---------------------------------------------------*/
        sb.append(eb.returnType);
        sb.append("RETURN_EXEC;\n");
        sb.append("}\n");
        sb.append("#undef RETURN_EXCEPTION\n\n");
        methods.add(sb.toString());
    }

    /**
     * Writes the final C source to file
     *
     * @param filename the name of the file that will be created
     * @throws IOException if the file can not be created
     */
    public void writeToFile(final String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        defines.forEach(x -> {
            content.append(x).append("\n");
        });
        headers.forEach(x -> {
            content.append(x).append("\n");
        });
        methods.forEach(x -> {
            content.append(x).append("\n");
        });
        Files.write(Paths.get(filename), content.toString().getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    /**
     * Mangle a single char in a class name or method name in order to support it in the JNI signature
     *
     * @param charval The integer value of the char that will be mangled
     * @return A string representing the mangled character
     */
    private static String mangleJNIChar(int charval) {
        if (charval <= 127) {
            switch (charval) {
                case '_':
                    return "_1";
                case '/':
                    return "_";
                case '$':
                    return "_00024";
                default:
                    return Character.toString((char) charval);
            }
        } else {
            return String.format("_%05x", charval);
        }
    }

    /**
     * Creates the mangled method name that will be used as the JNI signature.
     *
     * @param className  The original name of the Java class
     * @param methodName The original name of the Java method
     * @param overloaded If the method is overloaded at least once in the Java code.
     * @param signature  The signature of the Java method
     * @return The method name in JNI
     */
    private String mangleCMethodName(final String className, final String methodName, boolean overloaded,
                                     final MethodSignature signature) {
        StringBuilder sb = new StringBuilder();
        sb.append("Java_");
        sb.append(className.chars().mapToObj(CSourceGenerator::mangleJNIChar).collect(Collectors.joining()));
        sb.append('_');
        sb.append(methodName.chars().mapToObj(CSourceGenerator::mangleJNIChar).collect(Collectors.joining()));
        if (overloaded) //add special signature for overloaded methods
        {
            sb.append("__");
            for (int i = 0; i < signature.getInput().size(); i++) {
                sb.append(signature.getInput().get(i).getOverloadName());
            }
        }
        return sb.toString();
    }

    /**
     * Generates the VM table composed of opname - opcode values, used for the self debugging
     *
     * @return A string containing the generated table in the C language.
     */
    public static String generateVMTable() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder("enum Ops\n{\n");
        String[] opname = {
                "STACK", "PUSH", "PUSH2", "POP", "POP2", "DUP", "DUP2", "DUPX1", "DUPX2", "DUP2X1", "DUP2X2", "SWAP",
                "KILL", "ACK", "CLR", "FRONT"
        };
        HashSet<Integer> opcodes = new HashSet<>();
        while (opcodes.size() < opname.length) {
            opcodes.add(rand.nextInt(0xFF));
        }
        Iterator<Integer> opcodesIter = opcodes.iterator();
        for (String op : opname) {
            sb.append('\t');
            sb.append(op);
            sb.append(" = ");
            sb.append(opcodesIter.next());
            sb.append(",\n");
        }
        sb.append("};\n");
        return sb.toString();
    }

    public static Stack<SecretKey> generateKeys(int num) {
        SecureRandom srand = new SecureRandom();
        KeyGenerator gen = null;
        try {
            gen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        gen.init(256, srand);
        Stack<SecretKey> ret = new Stack<>();
        for (int i = 0; i < num; i++) {
            ret.add(gen.generateKey());
        }
        return ret;
    }

    public static String getKeyAsMaskedCString(SecretKey key, SecretKey mask, String varName) {
        StringBuilder sb = new StringBuilder("unsigned char ").append(varName).append("[] = {");
        byte[] bkey = key.getEncoded();
        byte[] bxor = mask.getEncoded();
        assert bkey.length == bxor.length;
        for (int i = 0; i < bkey.length; i++) {
            sb.append(String.format("0x%02X", (byte) (bkey[i] ^ bxor[i]))).append(",");
        }
        sb.append("};\n");
        return sb.toString();
    }

    public static String getKeyAsCString(SecretKey key, String varName) {
        StringBuilder sb = new StringBuilder("unsigned char ").append(varName).append("[] = {");
        for (byte val : key.getEncoded()) {
            sb.append(String.format("0x%02X", val)).append(",");
        }
        sb.append("};\n");
        return sb.toString();
    }
}
