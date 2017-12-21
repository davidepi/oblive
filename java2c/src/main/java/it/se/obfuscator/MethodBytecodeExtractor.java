package it.se.obfuscator;

import it.se.obfuscator.support.ExtractedBytecode;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class MethodBytecodeExtractor extends MethodVisitor
{
    ExtractedBytecode eb;
    private int count_functions;

    public MethodBytecodeExtractor(boolean isStatic)
    {
        super(ASM5);
        eb = new ExtractedBytecode(isStatic);
        count_functions = 0;
    }

    public ExtractedBytecode getBytecode()
    {
        return this.eb;
    }


    @Override
    public void visitMaxs(int maxStack, int maxLocals)
    {
        eb.maxStack = maxStack;
        eb.maxLVar = maxLocals;
    }

    @Override
    public void visitVarInsn(int opcode, int var)
    {
        switch(opcode)
        {
            case ILOAD:
            case ALOAD:
            case DLOAD:
                eb.statements.add("_Load(_stack,_vars,&_index,"+var+");");break;
            default: System.err.println("Unimplemented opcode: "+ opcode);System.exit(1);
        }
    }

    @Override
    public void visitInsn(int opcode)
    {
        switch(opcode)
        {
            case IADD: eb.statements.add("_IAdd(_stack,&_index);");break;
            case ARETURN: eb.statements.add("ARETURN;");break;
            case IRETURN: eb.statements.add("IRETURN;");break;
            case LRETURN: eb.statements.add("LRETURN;");break;
            case FRETURN: eb.statements.add("FRETURN;");break;
            case DRETURN: eb.statements.add("DRETURN;");break;
            case RETURN: eb.statements.add("VRETURN;");break;
            default: System.err.println("Unimplemented opcode: "+opcode);System.exit(1);
        }
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
    {
        switch(opcode)
        {
            case INVOKEVIRTUAL:
            {
                int openParIndex = desc.indexOf('(');
                int closeParIndex = desc.indexOf(')');
                char returnType = desc.substring(closeParIndex+1,desc.length()).charAt(0);
                String inputParamsSignature = jobjectRemover(desc.substring(openParIndex+1,closeParIndex));
                String argumentsName = "function_vals"+count_functions;
                eb.statements.add("jvalue "+argumentsName+"["+inputParamsSignature.length()+"];");
                for(int i=inputParamsSignature.length()-1;i>=0;i--)
                    if(inputParamsSignature.charAt(i)!='D' && inputParamsSignature.charAt(i)!='F')
                        eb.statements.add(argumentsName+"["+i+"]."+Character.toLowerCase(inputParamsSignature.charAt(i))+"=("+CSourceGenerator.signature2string(inputParamsSignature.charAt(i))+")pop(_stack,&_index);");
                    else
                    {
                        eb.statements.add("tmpdouble = pop(_stack,&_index);");
                        eb.statements.add(argumentsName + "[" + i + "]." + Character.toLowerCase(inputParamsSignature.charAt(i)) + "=*(" + CSourceGenerator.signature2string(inputParamsSignature.charAt(i)) + "*)&tmpdouble;");
                    }
                eb.statements.add("_InvokeVirtual_"+CSourceGenerator.signature2string(returnType)+"(env,_stack,&_index,\"" + owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");
                break;
            }
            default: System.err.println("Unimplemented opcode: "+opcode);System.exit(1);
        }
    }

    //since I don't care the name of the class I transform it into a simple L to know that it should be a jobject
    private String jobjectRemover(String in)
    {
        StringBuilder sb = new StringBuilder();
        boolean parsing = false;

        for(int i = 0;i<in.length();i++)
            if(in.charAt(i)=='L')
            {
                parsing = true;
                sb.append('L');
            }
            else if(in.charAt(i)==';' && parsing)
                parsing = false;
            else if(!parsing)
                sb.append(in.charAt(i));

        return sb.toString();
    }
}
