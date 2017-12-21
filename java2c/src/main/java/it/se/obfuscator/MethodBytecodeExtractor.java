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
            case ILOAD: eb.statements.add("_ILoad(_stack,_vars,&_index,"+var+");");break;
            case ALOAD: eb.statements.add("_ALoad(_stack,_vars,&_index,"+var+");");break;
            default: System.err.println("Unimplemented opcode: "+ opcode);System.exit(1);
        }
    }

    @Override
    public void visitInsn(int opcode)
    {
        switch(opcode)
        {
            case IADD: eb.statements.add("_IAdd(_stack,&_index);");break;
            case IRETURN: eb.statements.add("IRETURN;");break;
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
                //void
                if(desc.charAt(desc.length()-1)=='I')
                {
                    String signatureWoReturn = desc.substring(1,desc.indexOf(')',1));
                    String argumentsName = "function_vals"+count_functions;
                    eb.statements.add("jvalue "+argumentsName+"["+signatureWoReturn.length()+"];");
                    for(int i =0;i<signatureWoReturn.length();i++)
                        eb.statements.add(argumentsName+"["+i+"]."+Character.toLowerCase(signatureWoReturn.charAt(i))+
                                "=("+CSourceGenerator.signature2string(signatureWoReturn.charAt(i))+")pop(_stack,&_index);");
                    eb.statements.add("_InvokeVirtual_int(env,_stack,&_index,\"" + owner + "\",\"" + name + "\",\"" + desc + "\","+argumentsName+");");
                }
                else
                {
                    System.err.println("Unimplemented opcode: "+opcode);System.exit(1);
                }
                break;
            }
            default: System.err.println("Unimplemented opcode: "+opcode);System.exit(1);
        }
    }
}
