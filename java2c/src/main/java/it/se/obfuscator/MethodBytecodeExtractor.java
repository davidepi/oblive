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
        switch(opcode)
        {
            case IF_ICMPEQ: eb.statements.add("_ISub(_stack,&_index);");eb.statements.add("if(!pop(_stack,&_index).i)"); break;
            case IF_ICMPNE: eb.statements.add("_ISub(_stack,&_index);");eb.statements.add("if(pop(_stack,&_index).i)");break;
            case IF_ICMPLT: eb.statements.add("_ISub(_stack,&_index);");eb.statements.add("if(pop(_stack,&_index).i<0)");break;
            case IF_ICMPLE: eb.statements.add("_ISub(_stack,&_index);");eb.statements.add("if(pop(_stack,&_index).i<=0)");break;
            case IF_ICMPGT: eb.statements.add("_ISub(_stack,&_index);");eb.statements.add("if(pop(_stack,&_index).i>0)");break;
            case IF_ICMPGE: eb.statements.add("_ISub(_stack,&_index);");eb.statements.add("if(pop(_stack,&_index).i>=0)"); break;
            case IF_ACMPEQ: eb.statements.add("acmp(env,_stack,&_index);");eb.statements.add("if(pop(_stack,&_index).i)"); break;
            case IF_ACMPNE: eb.statements.add("acmp(env,_stack,&_index);");eb.statements.add("if(!pop(_stack,&_index).i)");break;
            case IFEQ: eb.statements.add("if(!pop(_stack,&_index).i)");break;
            case IFNE: eb.statements.add("if(pop(_stack,&_index).i)");break;
            case IFLT: eb.statements.add("if(pop(_stack,&_index).i<0)");break;
            case IFLE: eb.statements.add("if(pop(_stack,&_index).i<=0)");break;
            case IFGT: eb.statements.add("if(pop(_stack,&_index).i>0)");break;
            case IFGE: eb.statements.add("if(pop(_stack,&_index).i>=0)");break;
            case IFNULL: eb.statements.add("if(pop(_stack,&_index).l==0x0)");break;
            case IFNONNULL: eb.statements.add("if(pop(_stack,&_index).l!=0x0)");break;
            case GOTO: break;
            default:
                throw new IllegalPatternException("Unimplemented opcode: "+opcode);
        }
        eb.statements.add("goto LABEL_"+label.toString()+";");
        eb.usedLabels.add(label.toString());
    }

    @Override
    public void visitLabel(Label label)
    {
        eb.statements.add("LABEL_"+label.toString()+":");
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels)
    {
        eb.statements.add("switch(pop(_stack,&_index).i){");
        for(int i=0;i<labels.length;i++)
        {
            eb.usedLabels.add(labels[i].toString());
            eb.statements.add("case "+(i+min)+": goto LABEL_"+labels[i].toString()+";");
        }
        eb.usedLabels.add(dflt.toString());
        eb.statements.add("default: goto LABEL_"+dflt.toString()+";");
        eb.statements.add("}");
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels)
    {
        eb.statements.add("switch(pop(_stack,&_index).i){");
        for(int i=0;i<labels.length;i++)
        {
            eb.usedLabels.add(labels[i].toString());
            eb.statements.add("case "+(keys[i])+": goto LABEL_"+labels[i].toString()+";");
        }
        eb.usedLabels.add(dflt.toString());
        eb.statements.add("default: goto LABEL_"+dflt.toString()+";");
        eb.statements.add("}");
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims)
    {
        throw new IllegalPatternException("Unimplemented opcode: MULTINEWARRAY");
    }

    @Override
    public void visitIincInsn(int var, int increment)
    {
        if(increment==1)
            eb.statements.add("(_vars["+var+"].i)++;");
        else if(increment==-1)
            eb.statements.add("(_vars["+var+"].i)--;");
        else
            eb.statements.add("_Iinc(_vars,"+var+","+increment+");");
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
            case NOP:break;
            case ACONST_NULL: eb.statements.add("push0(_stack,&_index);");break;
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
            case IREM: eb.statements.add("_IRem(_stack,&_index);");break;
            case LREM: eb.statements.add("_LRem(_stack,&_index);");break;
            case FREM: eb.statements.add("_FRem(_stack,&_index);");break;
            case DREM: eb.statements.add("_DRem(_stack,&_index);");break;
            case INEG: eb.statements.add("_INeg(_stack,&_index);");break;
            case LNEG: eb.statements.add("_LNeg(_stack,&_index);");break;
            case FNEG: eb.statements.add("_FNeg(_stack,&_index);");break;
            case DNEG: eb.statements.add("_DNeg(_stack,&_index);");break;
            case ISHL: eb.statements.add("_IShl(_stack,&_index);");break;
            case LSHL: eb.statements.add("_LShl(_stack,&_index);");break;
            case ISHR: eb.statements.add("_IShr(_stack,&_index);");break;
            case LSHR: eb.statements.add("_LShr(_stack,&_index);");break;
            case IUSHR: eb.statements.add("_IUShr(_stack,&_index);");break;
            case LUSHR: eb.statements.add("_LUShr(_stack,&_index);");break;
            case IAND: eb.statements.add("_IAnd(_stack,&_index);");break;
            case LAND: eb.statements.add("_LAnd(_stack,&_index);");break;
            case IOR: eb.statements.add("_IOr(_stack,&_index);");break;
            case LOR: eb.statements.add("_LOr(_stack,&_index);");break;
            case IXOR: eb.statements.add("_IXor(_stack,&_index);");break;
            case LXOR: eb.statements.add("_LXor(_stack,&_index);");break;
            case I2L: eb.statements.add("_int2long(_stack,&_index);");break;
            case I2F: eb.statements.add("_int2float(_stack,&_index);");break;
            case I2D: eb.statements.add("_int2double(_stack,&_index);");break;
            case L2I: eb.statements.add("_long2int(_stack,&_index);");break;
            case L2F: eb.statements.add("_long2float(_stack,&_index);");break;
            case L2D: eb.statements.add("_long2double(_stack,&_index);");break;
            case F2I: eb.statements.add("_float2int(_stack,&_index);");break;
            case F2L: eb.statements.add("_float2long(_stack,&_index);");break;
            case F2D: eb.statements.add("_float2double(_stack,&_index);");break;
            case D2I: eb.statements.add("_double2int(_stack,&_index);");break;
            case D2L: eb.statements.add("_double2long(_stack,&_index);");break;
            case D2F: eb.statements.add("_double2float(_stack,&_index);");break;
            case I2B: eb.statements.add("_int2byte(_stack,&_index);");break;
            case I2C: eb.statements.add("_int2char(_stack,&_index);");break;
            case I2S: eb.statements.add("_int2short(_stack,&_index);");break;
            case LCMP: eb.statements.add("lcmp(_stack,&_index);");break;
            case FCMPL: eb.statements.add("fcmpl(_stack,&_index);");break;
            case FCMPG: eb.statements.add("fcmpg(_stack,&_index);");break;
            case DCMPL: eb.statements.add("dcmpl(_stack,&_index);");break;
            case DCMPG: eb.statements.add("dcmpg(_stack,&_index);");break;
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
            case "java.lang.Float": eb.statements.add("pushf(_stack,&_index,"+(Float)cst+"f);");break;
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
        String argumentsName = "function_vals"+count_functions++;
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
