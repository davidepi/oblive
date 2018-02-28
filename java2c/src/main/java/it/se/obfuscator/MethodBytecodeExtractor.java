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
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
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
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
        }
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
    {
        MethodSignature signature = new MethodSignature(desc);
        String argumentsName = "function_vals"+count_functions;
        JniType currentType;
        StringBuilder statementBuilder = new StringBuilder();
        eb.statements.add("jvalue "+argumentsName+"["+signature.getInput().size()+"];");
        for(int i=signature.getInput().size()-1;i>=0;i--)
        {
            //EXAMPLE:
            //function_vals0[1] = pop(_stack,&_index);
            statementBuilder.setLength(0);
            currentType = signature.getInput().get(i);
            statementBuilder.append(argumentsName).append("[").append(i).append("]=");
            if(currentType.isDoubleLength())
                statementBuilder.append("pop2(_stack,&_index);");
            else
                statementBuilder.append("pop(_stack,&_index);");
            eb.statements.add(statementBuilder.toString());
        }
        switch(opcode)
        {
            case INVOKEVIRTUAL:
                eb.statements.add("_InvokeVirtual_"+signature.getReturnType().getJniName()+"(env,_stack,&_index,\"" +
                                  owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");break;
            case INVOKESTATIC:
                eb.statements.add("_InvokeStatic_"+signature.getReturnType().getJniName()+"(env,_stack,&_index,\"" +
                        owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");break;
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
        }
    }
}
