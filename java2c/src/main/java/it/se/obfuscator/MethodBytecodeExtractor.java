package it.se.obfuscator;

import it.se.obfuscator.support.ExtractedBytecode;
import it.se.obfuscator.support.JniType;
import it.se.obfuscator.support.MethodSignature;
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
            case FLOAD:
                eb.statements.add("_Load(_stack,_vars,&_index,"+var+");");break;
            case LLOAD:
            case DLOAD:
                eb.statements.add("_Load2(_stack,_vars,&_index,"+var+");");break;
            default: System.err.println("Unimplemented opcode: "+ opcode);System.exit(1);
        }
    }

    @Override
    public void visitInsn(int opcode)
    {
        switch(opcode)
        {
            case IADD: eb.statements.add("_IAdd(_stack,&_index);");break;
            case ICONST_1: eb.statements.add("push(_stack,&_index,(void*)0x1);");break;
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
        MethodSignature signature = new MethodSignature(desc);
        switch(opcode)
        {
            case INVOKEVIRTUAL:
            {
                String argumentsName = "function_vals"+count_functions;
                JniType currentType;
                StringBuilder statementBuilder = new StringBuilder();
                eb.statements.add("jvalue "+argumentsName+"["+signature.getInput().size()+"];");
                for(int i=signature.getInput().size()-1;i>=0;i--)
                {
                    //EXAMPLE:
                    //function_vals0[1].i = (jint)pop(_stack,&_index);
                    statementBuilder.setLength(0);
                    currentType = signature.getInput().get(i);
                    statementBuilder.append(argumentsName).append("[").append(i).append("].");
                    statementBuilder.append(currentType.getJvalueLetter());
                    statementBuilder.append("=(");
                    statementBuilder.append(currentType.getJniName());
                    if(currentType.isDoubleLength())
                        statementBuilder.append(")pop2(_stack,&_index);");
                    else
                        statementBuilder.append(")pop(_stack,&_index);");
                    eb.statements.add(statementBuilder.toString());
                }
                eb.statements.add("_InvokeVirtual_"+signature.getReturnType().getJniName()+"(env,_stack,&_index,\"" +
                                  owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");
                break;
            }
            default: System.err.println("Unimplemented opcode: "+opcode);System.exit(1);
        }
    }
}
