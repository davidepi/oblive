package it.se.obfuscator;

import it.se.obfuscator.support.ExtractedBytecode;
import it.se.obfuscator.support.JniType;
import it.se.obfuscator.support.MethodSignature;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import static org.objectweb.asm.Opcodes.*;

public class MethodBytecodeExtractor extends MethodVisitor
{
    ExtractedBytecode eb;
    private int count_functions;
    private boolean processingNew;

    public MethodBytecodeExtractor(boolean isStatic)
    {
        super(ASM5);
        processingNew = false;
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
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs)
    {
        throw new IllegalPatternException("Unimplemented opcode: INVOKEDYNAMIC");
    }

    @Override
    public void visitJumpInsn(int opcode, Label label)
    {
        throw new IllegalPatternException("Unimplemented Jump opcode");
    }

    @Override
    public void visitLabel(Label label)
    {
        eb.statements.add("LABEL_"+label.toString()+":");
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels)
    {
        throw new IllegalPatternException("Unimplemented opcode: TABLESWITCH");
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels)
    {
        throw new IllegalPatternException("Unimplemented opcode: LOOKUPSWITCH");
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims)
    {
        throw new IllegalPatternException("Unimplemented opcode: MULTINEWARRAY");
    }

    @Override
    public void visitIincInsn(int var, int increment)
    {
        throw new IllegalPatternException("Unimplemented opcode: IINC");
    }

    @Override
    public void visitVarInsn(int opcode, int var)
    {
        switch(opcode)
        {
            case ILOAD:
            case ALOAD:
            case FLOAD:
                eb.statements.add("_Load(_stack,_vars,&_index,"+var+");");
                break;
            case LLOAD:
            case DLOAD:
                eb.statements.add("_Load2(_stack,_vars,&_index,"+var+");");
                break;
            case ISTORE:
            case ASTORE:
            case FSTORE:
                eb.statements.add("_Store(_stack,_vars,&_index,"+var+");");
                break;
            case LSTORE:
            case DSTORE:
                eb.statements.add("_Store2(_stack,_vars,&_index,"+var+");");
                break;
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
        }
    }

    @Override
    public void visitInsn(int opcode)
    {
        switch(opcode)
        {
            case ICONST_M1: eb.statements.add("pushi(_stack,&_index,-1);");break;
            case ICONST_0: eb.statements.add("pushi(_stack,&_index,0);");break;
            case ICONST_1: eb.statements.add("pushi(_stack,&_index,1);");break;
            case ICONST_2: eb.statements.add("pushi(_stack,&_index,2);");break;
            case ICONST_3: eb.statements.add("pushi(_stack,&_index,3);");break;
            case ICONST_4: eb.statements.add("pushi(_stack,&_index,4);");break;
            case ICONST_5: eb.statements.add("pushi(_stack,&_index,5);");break;
            case LCONST_0: eb.statements.add("pushl(_stack,&_index,0);");break;
            case LCONST_1: eb.statements.add("pushl(_stack,&_index,1);");break;
            case FCONST_0: eb.statements.add("pushf(_stack,&_index,0.f);");break;
            case FCONST_1: eb.statements.add("pushf(_stack,&_index,1.f);");break;
            case FCONST_2: eb.statements.add("pushf(_stack,&_index,2.f);");break;
            case DCONST_0: eb.statements.add("pushd(_stack,&_index,0.0);");break;
            case DCONST_1: eb.statements.add("pushd(_stack,&_index,1.0);");break;
            case IADD: eb.statements.add("_IAdd(_stack,&_index);");break;
            case LADD: eb.statements.add("_LAdd(_stack,&_index);");break;
            case FADD: eb.statements.add("_FAdd(_stack,&_index);");break;
            case DADD: eb.statements.add("_DAdd(_stack,&_index);");break;
            case ISUB: eb.statements.add("_ISub(_stack,&_index);");break;
            case LSUB: eb.statements.add("_LSub(_stack,&_index);");break;
            case FSUB: eb.statements.add("_FSub(_stack,&_index);");break;
            case DSUB: eb.statements.add("_DSub(_stack,&_index);");break;
            case IMUL: eb.statements.add("_IMul(_stack,&_index);");break;
            case LMUL: eb.statements.add("_LMul(_stack,&_index);");break;
            case FMUL: eb.statements.add("_FMul(_stack,&_index);");break;
            case DMUL: eb.statements.add("_DMul(_stack,&_index);");break;
            case IDIV: eb.statements.add("_IDiv(_stack,&_index);");break;
            case LDIV: eb.statements.add("_LDiv(_stack,&_index);");break;
            case FDIV: eb.statements.add("_FDiv(_stack,&_index);");break;
            case DDIV: eb.statements.add("_DDiv(_stack,&_index);");break;
            case ARETURN: eb.statements.add("ARETURN;");break;
            case IRETURN: eb.statements.add("IRETURN;");break;
            case LRETURN: eb.statements.add("LRETURN;");break;
            case FRETURN: eb.statements.add("FRETURN;");break;
            case DRETURN: eb.statements.add("DRETURN;");break;
            case RETURN: eb.statements.add("VRETURN;");break;
            case DUP:
                if(!processingNew)
                    //TODO: duplicate stack
                    throw new IllegalPatternException("Unimplemented opcode: "+opcode);
                else
                    /* do nothing */;
                break;
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
        }
   }

    @Override
    public void visitIntInsn(int opcode, int operand)
    {
        switch(opcode)
        {
            case BIPUSH:
            case SIPUSH:
                eb.statements.add("pushi(_stack,&_index,"+operand+");");break;
            case NEWARRAY:
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
        }
    }

    @Override
    public void visitLdcInsn(Object cst)
    {
        Class cls = cst.getClass();
        switch(cls.getName())
        {
            case "java.lang.Integer": eb.statements.add("pushi(_stack,&_index,"+(Integer)cst+");");break;
            case "java.lang.Long": eb.statements.add("pushl(_stack,&_index,"+(Long)cst+");");break;
            case "java.lang.Float": eb.statements.add("pushf(_stack,&_index,"+(Float)cst+");");break;
            case "java.lang.Double": eb.statements.add("pushd(_stack,&_index,"+(Double)cst+");");break;
            case "java.lang.String":
            {
                String str = (String)cst;
                int stringID = System.identityHashCode(str);
                eb.statements.add("jchar string_"+ stringID+"["+str.length()+"];");
                for(int i=0;i<str.length();i++)
                    eb.statements.add("string_"+stringID+"["+i+"]="+(short)str.charAt(i)+";");
                eb.statements.add("_Ldc(env,_stack,&_index,string_"+stringID+","+str.length() + ");");
                break;
            }
            default:
                throw new IllegalPatternException("Unimplemented opcode: LDC");
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
            //EXAMPLE RESULT OF THE STRING BUILDER:
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
            case INVOKEINTERFACE:
            case INVOKEVIRTUAL:
                eb.statements.add("_InvokeVirtual_"+signature.getReturnType().getJniName()+"(env,_stack,&_index,\"" +
                                  owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");break;
            case INVOKESPECIAL:
                if(!processingNew)
                    eb.statements.add("_InvokeSpecial_"+signature.getReturnType().getJniName()+"(env,_stack,&_index,\"" +
                        owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");
                else
                {
                    assert(name.equals("<init>"));
                    assert(signature.getReturnType().getJniName().equals("void"));
                    eb.statements.add("_New(env,_stack,&_index,\"" + owner + "\",\"" + desc + "\"," + argumentsName + ");");
                    processingNew = false;
                }
                break;
            case INVOKESTATIC:
                eb.statements.add("_InvokeStatic_"+signature.getReturnType().getJniName()+"(env,_stack,&_index,\"" +
                        owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");break;
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
        }
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc)
    {
        JniType type = new JniType(desc);
        switch(opcode)
        {
            case GETFIELD:
                eb.statements.add("_GetField_"+type.getJniName()+"(env,_stack,&_index,\""+owner+"\",\""+name+"\",\""+desc+"\");");
                break;
            case GETSTATIC:
                eb.statements.add("_GetStatic_"+type.getJniName()+"(env,_stack,&_index,\""+owner+"\",\""+name+"\",\""+desc+"\");");
                break;
            case PUTFIELD:
                eb.statements.add("_SetField_"+type.getJniName()+"(env,_stack,&_index,\""+owner+"\",\""+name+"\",\""+desc+"\");");
                break;
            case PUTSTATIC:
                eb.statements.add("_SetStatic_"+type.getJniName()+"(env,_stack,&_index,\""+owner+"\",\""+name+"\",\""+desc+"\");");
                break;
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
        }
    }

    @Override
    public void visitTypeInsn(int opcode, String type)
    {
        switch(opcode)
        {
            case NEW:
                    processingNew = true;
                break;
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
        }
    }
}
