package it.oblive;


import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.AntidebugTime;
import it.oblive.support.ExtractedBytecode;
import it.oblive.support.JniType;
import it.oblive.support.MethodSignature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
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
     * Append the content of a header C file in the resources to the output file
     *
     * @param filename Name of the INPUT C  header file. Must be in the resources.
     */
    public void addHeaderInResources(@NotNull final String filename) {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(filename);
        assert stream != null;
        String fileContent = new BufferedReader(new InputStreamReader(stream))
                .lines().collect(Collectors.joining("\n"));
        headers.add(fileContent);
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
            sb.append("#define RETURN_EXCEPTION return;\n");
        } else {
            sb.append("#define RETURN_EXCEPTION return 0;\n");
        }

        //generate JNI signature
        sb.append("JNIEXPORT ");
        sb.append(signature.getReturnType().getJniName());
        if (signature.getReturnType().getArrayDepth() > 0) {
            sb.append("Array");
        }
        sb.append(" JNICALL ");
        sb.append("Java_");
        sb.append(className.replace("_", "_1").replace('/', '_').replace("$", "_00024"));
        sb.append('_');
        sb.append(methodName.replace("_", "_1"));
        if (overloaded) //add special signature for overloaded methods
        {
            sb.append("__");
            for (int i = 0; i < signature.getInput().size(); i++) {
                sb.append(signature.getInput().get(i).getOverloadName());
            }
        }
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
        //antidebug techniques
        if (antidebugTime || antidebugSelf) {
            sb.append("break_java_debugger();\n");
            if (antidebugTime) {
                sb.append("time_t debug_timer;\n");
                sb.append("time_start(&debug_timer);\n");
            }
            if (antidebugSelf) {
                sb.append("int child = self_debug(env, \"" + libname + "vm.o\");\n");
                sb.append("if(!child)return 0;\n");
            } else {
                sb.append("int child = 0;\n");
            }
        } else {
            sb.append("int child = 0;\n");
        }

        //generate stack vars
        sb.append("generic_t __return_retval__;\n");
        sb.append("uint32_t _index = 0;\n");
        sb.append("generic_t _stack[");
        sb.append(eb.maxStack);
        sb.append("];\n");
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
            sb.append("self_debug_end(child);\n");
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
     * Generates the VM table composed of opname - opcode values, used for the self debugging
     *
     * @return A string containing the generated table in the C language.
     */
    public static String generateVMTable() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder("enum Ops\n{\n");
        String[] opname = {
                "PUSH", "PUSH2", "POP", "POP2", "DUP", "DUP2", "DUPX1", "DUPX2", "DUP2X1", "DUP2X2", "SWAP",
                "KILL", "SYN", "ACK"
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
}
