package it.se.obfuscator;

import it.se.obfuscator.support.ExtractedBytecode;
import it.se.obfuscator.support.MethodSignature;

import java.util.ArrayList;

public class CSourceGenerator
{
    public static String generateCode(String className, String methodName, MethodSignature signature, ExtractedBytecode eb)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("JNIEXPORT ");
        sb.append(signature.getReturnType().getJniName());
        sb.append(" JNICALL ");
        sb.append("Java_");
        sb.append(className.replace('/','_'));
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

        //push arguments into local vars
        int vars_index = 0; //vars_index, could differ from actual operands index because of static functions or double words;
        if(!eb.isStatic)
        {
            sb.append("_vars[0] = (generic_t)this;\n"); //this pointer is pushed only if the class is not static
            vars_index++;
        }
        for(int i=0;i<signature.getInput().size();i++)
        {
            sb.append("_vars[");
            sb.append(vars_index++);
            sb.append("] = (generic_t)var");
            sb.append(i+1);
            sb.append(";\n");
            if(signature.getInput().get(i).isDoubleLength())
            {
                vars_index++;
            }
        }
        sb.append('\n');

        //push statements
        for(int i=0;i<eb.statements.size();i++)
        {
            sb.append(eb.statements.get(i));
            sb.append('\n');
        }
        sb.append("}\n\n");
        return sb.toString();
    }
}
