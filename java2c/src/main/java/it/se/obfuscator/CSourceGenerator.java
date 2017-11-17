package it.se.obfuscator;

import it.se.obfuscator.support.ExtractedBytecode;

import java.util.ArrayList;

public class CSourceGenerator
{
    public static String generateCode(String className, String methodName, String signature, ExtractedBytecode eb)
    {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> sign = tokenizeString(signature);
        sb.append("JNIEXPORT ");
        sb.append(sign.get(sign.size()-1));
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
        for(int i=0;i<sign.size()-1;i++)
        {
            sb.append(", ");
            sb.append(sign.get(i));
            sb.append(" ");
            sb.append("var");
            sb.append(i+1); //since var0 is called `this`
        }
        sb.append(")\n");
        sb.append("{\n");

        //generate stack vars
        sb.append("uint32_t _index = 0;\n");
        sb.append("void* _stack[");
        sb.append(eb.maxStack);
        sb.append("];\n");
        sb.append("void* _vars[");
        sb.append(eb.maxLVar);
        sb.append("];\n");

        //push arguments into local vars
        if(!eb.isStatic)
        {
            sb.append("_vars[0] = (void*)this;\n"); //this pointer is pushed only if the class is not static
            for(int i=1;i<sign.size();i++)
            {
                sb.append("_vars[");
                sb.append(i);
                sb.append("] = (void*)var");
                sb.append(i);
                sb.append(";\n");
            }
        }
        else
        {
            for(int i=1;i<sign.size();i++)
            {
                sb.append("_vars[");
                sb.append(i-1); //this is the difference between static and non-static:
                                //if static the vars[] array in c is offset by 1 because var[0] (this) is missing
                sb.append("] = (void*)var");
                sb.append(i);
                sb.append(";\n");
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

    private static String signature2string(char sign)
    {
        switch(sign)
        {
            case 'I':
                return "jint";
            case 'V':
                return "void";
            case 'Z':
                return "jboolean";
            case 'B':
                return "jbyte";
            case 'C':
                return "jchar";
            case 'S':
                return "jshort";
            case 'J':
                return "jlong";
            case 'F':
                return "jfloat";
            case 'D':
                return "jdouble";
            default:
                return "jobject";
        }
    }

    private static ArrayList<String> tokenizeString(String in)
    {
        ArrayList<String> ret = new ArrayList<String>();
        boolean obj=false; //used while reading an object, a sort of "context"

        for(int i=0;i<in.length();i++)
        {
            switch(in.charAt(i))
            {
                case ';':obj = false;break;
                case 'L':obj = true;ret.add("jobject");break;
                case '(':break;
                case ')':break;
                default: ret.add(signature2string(in.charAt(i)));
            }
        }

        return ret;
    }
}
