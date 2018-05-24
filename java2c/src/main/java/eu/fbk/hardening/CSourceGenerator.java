package eu.fbk.hardening;

import eu.fbk.hardening.support.ExtractedBytecode;
import eu.fbk.hardening.support.JniType;
import eu.fbk.hardening.support.MethodSignature;
import eu.fbk.hardening.support.ExtractedBytecode;
import eu.fbk.hardening.support.JniType;
import eu.fbk.hardening.support.MethodSignature;

import java.util.ArrayList;

public class CSourceGenerator
{
    public static String generateCode(String className, String methodName, MethodSignature signature, ExtractedBytecode eb)
    {
        StringBuilder sb = new StringBuilder();
        if(signature.getReturnType().getJniName().equals("void"))
            sb.append("#define RETURN_EXCEPTION return;\n");
        else
            sb.append("#define RETURN_EXCEPTION return 0;\n");
        sb.append("JNIEXPORT ");
        sb.append(signature.getReturnType().getJniName());
        if(signature.getReturnType().getArrayDepth()>0)
            sb.append("Array");
        sb.append(" JNICALL ");
        sb.append("Java_");
        sb.append(className.replace('/','_').replace("$","_00024"));
        sb.append('_');
        sb.append(methodName);
        sb.append("(JNIEnv* env, ");
        if(!eb.isStatic)
            sb.append("jobject this");
        else
            sb.append("jclass staticClass");
        for(int i=0;i<signature.getInput().size();i++)
        {
            sb.append(", ");
            sb.append(signature.getInput().get(i).getJniName());
            sb.append(" ");
            sb.append("var");
            sb.append(i+1); //since var0 is called `this`
        }
        sb.append(")\n");
        sb.append("{\n");

        //generate stack vars
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
        int vars_index = 0; //vars_index, could differ from actual operands index because of static functions or double words;
        if(!eb.isStatic)
        {
            sb.append("_vars[0].l=this;\n"); //this pointer is pushed only if the class is not static
            vars_index++;
        }
        for(int i=0;i<signature.getInput().size();i++)
        {
            JniType currentType = signature.getInput().get(i);
            sb.append("_vars[");
            sb.append(vars_index++);
            sb.append("].");
            sb.append(currentType.getJvalueLetter());
            sb.append("=var");
            sb.append(i+1);
            sb.append(";\n");
            if(currentType.isDoubleLength())
            {
                vars_index++;
            }
        }
        sb.append('\n');

        //push statements
        for(int i=0;i<eb.statements.size();i++)
        {
            String str = eb.statements.get(i);
            if(str.length()>0)
            {
                sb.append(str);
                if (str.charAt(str.length()-1)!='\n')
                    sb.append('\n');
            }
        }
        sb.append("}\n");
        sb.append("#undef RETURN_EXCEPTION\n\n");
        return sb.toString();
    }
}
