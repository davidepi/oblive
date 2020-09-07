package it.oblive;


import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.AntidebugTime;
import it.oblive.support.ExtractedBytecode;
import it.oblive.support.JniType;
import it.oblive.support.MethodSignature;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * This class creates the C source file starting from the output of the MethodBytecodeExtractor.
 *
 * @author D.Pizzolotto
 */
public class CSourceGenerator {

    /**
     * This method transforms the ExtractedBytecode resulting from a MethodBytecodeExtractor into a fully-functional C
     * source code, along with performing the method name mangling. The implementation of the various opcodes should be
     * added BEFORE the results of this call, otherwise linking would fail
     *
     * @param className    name of the class owning the native method
     * @param methodName   name of the native method
     * @param signature    signature of the native method
     * @param eb           result of the MethodBytecodeExtractor
     * @param overloaded   true if other methods within the same class and with the same name exists.
     * @param obfuscations a set containing the Class for every obfuscation requested.
     * @param libname      The name of the generated library. Used for invoking the second process in the self-debugging
     * @return a String representing the content of the generated source file
     */
    @NotNull
    public static String generateCode(String className, String methodName, @NotNull MethodSignature signature,
                                      ExtractedBytecode eb, boolean overloaded, HashSet<Class> obfuscations,
                                      String libname) {
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
