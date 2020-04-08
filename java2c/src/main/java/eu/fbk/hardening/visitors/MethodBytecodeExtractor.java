package eu.fbk.hardening.visitors;

import eu.fbk.hardening.support.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

/**
 * This visitor performs the analysis of every single opcode inside a method and replaces it with the text that will
 * be written in the C source. Usually this is a function call with the same name of the opcode. The actual function
 * implementation is provided in the resources
 *
 * @author D.Pizzolotto
 */
public class MethodBytecodeExtractor extends MethodVisitor {

    //Class containing all the data extracted from the method
    private ExtractedBytecode eb;
    //Number of function calls inside the method. This is needed to create the variable name for the parameters
    //(i.e. function_vals0, function_vals1, etc...)
    private int countFunctions;
    //record if the visitor is processing a New statement. This is needed because the DUP after the NEW must be ignored
    private boolean processingNew;
    //record the index of the current try-catch block. They must be ordered
    private int countTryCatch;
    //Number of LDC strings inside the method. Needed for the same reason of the method call
    private int countStrings;

    /**
     * Constructor
     *
     * @param version  ASM version
     * @param isStatic true if the extracted method is static, false otherwise
     */
    public MethodBytecodeExtractor(int version, boolean isStatic) {
        super(version);
        processingNew = false;
        eb = new ExtractedBytecode(isStatic);
        countFunctions = 0;
        countTryCatch = 0;
        countStrings = 0;
    }

    /**
     * Returns the ExtractedBytecode obtained by visiting the method
     *
     * @return the ExtractedBytecode
     */
    public ExtractedBytecode getBytecode() {
        return this.eb;
    }


    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        eb.maxStack = maxStack;
        eb.maxLVar = maxLocals;
    }

    @Override
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {

        throw new IllegalPatternError("Unimplemented opcode: INVOKEDYNAMIC");
    }

    @Override
    public void visitJumpInsn(int opcode, Label label) {
        switch (opcode) {
            case IF_ICMPEQ:
                eb.statements.add("_ISub(_stack,&_index);");
                eb.statements.add("if(!pop(_stack,&_index).i)");
                break;
            case IF_ICMPNE:
                eb.statements.add("_ISub(_stack,&_index);");
                eb.statements.add("if(pop(_stack,&_index).i)");
                break;
            case IF_ICMPLT:
                eb.statements.add("_ISub(_stack,&_index);");
                eb.statements.add("if(pop(_stack,&_index).i<0)");
                break;
            case IF_ICMPLE:
                eb.statements.add("_ISub(_stack,&_index);");
                eb.statements.add("if(pop(_stack,&_index).i<=0)");
                break;
            case IF_ICMPGT:
                eb.statements.add("_ISub(_stack,&_index);");
                eb.statements.add("if(pop(_stack,&_index).i>0)");
                break;
            case IF_ICMPGE:
                eb.statements.add("_ISub(_stack,&_index);");
                eb.statements.add("if(pop(_stack,&_index).i>=0)");
                break;
            case IF_ACMPEQ:
                eb.statements.add("acmp(env,_stack,&_index);");
                eb.statements.add("if(pop(_stack,&_index).i)");
                break;
            case IF_ACMPNE:
                eb.statements.add("acmp(env,_stack,&_index);");
                eb.statements.add("if(!pop(_stack,&_index).i)");
                break;
            case IFEQ:
                eb.statements.add("if(!pop(_stack,&_index).i)");
                break;
            case IFNE:
                eb.statements.add("if(pop(_stack,&_index).i)");
                break;
            case IFLT:
                eb.statements.add("if(pop(_stack,&_index).i<0)");
                break;
            case IFLE:
                eb.statements.add("if(pop(_stack,&_index).i<=0)");
                break;
            case IFGT:
                eb.statements.add("if(pop(_stack,&_index).i>0)");
                break;
            case IFGE:
                eb.statements.add("if(pop(_stack,&_index).i>=0)");
                break;
            case IFNULL:
                eb.statements.add("if(pop(_stack,&_index).l==0x0)");
                break;
            case IFNONNULL:
                eb.statements.add("if(pop(_stack,&_index).l!=0x0)");
                break;
            case GOTO:
                break;
            default:
                throw new IllegalPatternError("Unimplemented opcode: " + opcode);
        }
        eb.statements.add("goto LABEL_" + label.toString() + ";");
        eb.usedLabels.add("LABEL_" + label.toString());
    }

    @Override
    public void visitLabel(Label label) {
        eb.statements.add("LABEL_" + label.toString() + ": ;");
        eb.labels.add(label.toString());
    }

    @Override
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        eb.statements.add("switch(pop(_stack,&_index).i){");
        for (int i = 0; i < labels.length; i++) {
            eb.usedLabels.add("LABEL_" + labels[i].toString());
            eb.statements.add("case " + (i + min) + ": goto LABEL_" + labels[i].toString() + ";");
        }
        eb.usedLabels.add("LABEL_" + dflt.toString());
        eb.statements.add("default: goto LABEL_" + dflt.toString() + ";");
        eb.statements.add("}");
    }

    @Override
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        eb.statements.add("switch(pop(_stack,&_index).i){");
        for (int i = 0; i < labels.length; i++) {
            eb.usedLabels.add("LABEL_" + labels[i].toString());
            eb.statements.add("case " + (keys[i]) + ": goto LABEL_" + labels[i].toString() + ";");
        }
        eb.usedLabels.add("LABEL_" + dflt.toString());
        eb.statements.add("default: goto LABEL_" + dflt.toString() + ";");
        eb.statements.add("}");
    }

    @Override
    public void visitMultiANewArrayInsn(String desc, int dims) {
        switch (desc.charAt(desc.length() - 1)) {
            case 'I':
                eb.statements.add(handleSystemException("_NewMultidimensionalIntArray(env,_stack,&_index,\"" + desc + "\"," + dims + ")", NegativeArraySizeException.class));
                break;
            case 'Z':
                eb.statements.add(handleSystemException("_NewMultidimensionalBooleanArray(env,_stack,&_index,\"" + desc + "\"," + dims + ")", NegativeArraySizeException.class));
                break;
            case 'B':
                eb.statements.add(handleSystemException("_NewMultidimensionalByteArray(env,_stack,&_index,\"" + desc + "\"," + dims + ")", NegativeArraySizeException.class));
                break;
            case 'C':
                eb.statements.add(handleSystemException("_NewMultidimensionalCharArray(env,_stack,&_index,\"" + desc + "\"," + dims + ")", NegativeArraySizeException.class));
                break;
            case 'S':
                eb.statements.add(handleSystemException("_NewMultidimensionalShortArray(env,_stack,&_index,\"" + desc + "\"," + dims + ")", NegativeArraySizeException.class));
                break;
            case 'J':
                eb.statements.add(handleSystemException("_NewMultidimensionalLongArray(env,_stack,&_index,\"" + desc + "\"," + dims + ")", NegativeArraySizeException.class));
                break;
            case 'F':
                eb.statements.add(handleSystemException("_NewMultidimensionalFloatArray(env,_stack,&_index,\"" + desc + "\"," + dims + ")", NegativeArraySizeException.class));
                break;
            case 'D':
                eb.statements.add(handleSystemException("_NewMultidimensionalDoubleArray(env,_stack,&_index,\"" + desc + "\"," + dims + ")", NegativeArraySizeException.class));
                break;
            case ';':
                eb.statements.add(handleSystemException("_NewMultidimensionalObjectArray(env,_stack,&_index,\"" + desc + "\"," + dims + ")", NegativeArraySizeException.class));
                break;
            default:
                throw new IllegalPatternError("Unimplemented MULTIANEWARRAY array for type: " + desc);
        }
    }

    @Override
    public void visitIincInsn(int var, int increment) {
        if (increment == 1) {
            eb.statements.add("(_vars[" + var + "].i)++;");
        } else if (increment == -1) {
            eb.statements.add("(_vars[" + var + "].i)--;");
        } else {
            eb.statements.add("_Iinc(_vars," + var + "," + increment + ");");
        }
    }

    @Override
    public void visitVarInsn(int opcode, int var) {
        switch (opcode) {
            case ILOAD:
            case ALOAD:
            case FLOAD:
                eb.statements.add("_Load(_stack,_vars,&_index," + var + ");");
                break;
            case LLOAD:
            case DLOAD:
                eb.statements.add("_Load2(_stack,_vars,&_index," + var + ");");
                break;
            case ISTORE:
            case ASTORE:
            case FSTORE:
                eb.statements.add("_Store(_stack,_vars,&_index," + var + ");");
                break;
            case LSTORE:
            case DSTORE:
                eb.statements.add("_Store2(_stack,_vars,&_index," + var + ");");
                break;
            default:
                throw new IllegalPatternError("Unimplemented opcode: " + opcode);
        }
    }

    @Override
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        String handlerLabel = "LABEL_" + handler.toString();

        TryCatchBlock current = new TryCatchBlock();
        current.start = start.toString();
        current.end = end.toString();
        if (type == null)//generated inside monitor's implicit try-catch
        {
            type = "java/lang/Object";
        }
        current.catched = type;
        current.handle = handler.toString();
        current.order = countTryCatch++;
        eb.tryCatchBlocks.add(current);
        eb.catchedStatements.add(type);
        eb.usedLabels.add(handlerLabel);
    }

    @Override
    public void visitInsn(int opcode) {
        switch (opcode) {
            case NOP:
                break;
            case ACONST_NULL:
                eb.statements.add("push0(_stack,&_index);");
                break;
            case ICONST_M1:
                eb.statements.add("pushi(_stack,&_index,-1);");
                break;
            case ICONST_0:
                eb.statements.add("pushi(_stack,&_index,0);");
                break;
            case ICONST_1:
                eb.statements.add("pushi(_stack,&_index,1);");
                break;
            case ICONST_2:
                eb.statements.add("pushi(_stack,&_index,2);");
                break;
            case ICONST_3:
                eb.statements.add("pushi(_stack,&_index,3);");
                break;
            case ICONST_4:
                eb.statements.add("pushi(_stack,&_index,4);");
                break;
            case ICONST_5:
                eb.statements.add("pushi(_stack,&_index,5);");
                break;
            case LCONST_0:
                eb.statements.add("pushl(_stack,&_index,0);");
                break;
            case LCONST_1:
                eb.statements.add("pushl(_stack,&_index,1);");
                break;
            case FCONST_0:
                eb.statements.add("pushf(_stack,&_index,0.f);");
                break;
            case FCONST_1:
                eb.statements.add("pushf(_stack,&_index,1.f);");
                break;
            case FCONST_2:
                eb.statements.add("pushf(_stack,&_index,2.f);");
                break;
            case DCONST_0:
                eb.statements.add("pushd(_stack,&_index,0.0);");
                break;
            case DCONST_1:
                eb.statements.add("pushd(_stack,&_index,1.0);");
                break;
            case IALOAD:
                eb.statements.add(handleArrayIndexException("_IALoad(env,_stack,&_index)", false));
                break;
            case LALOAD:
                eb.statements.add(handleArrayIndexException("_LALoad(env,_stack,&_index)", false));
                break;
            case FALOAD:
                eb.statements.add(handleArrayIndexException("_FALoad(env,_stack,&_index)", false));
                break;
            case DALOAD:
                eb.statements.add(handleArrayIndexException("_DALoad(env,_stack,&_index)", false));
                break;
            case AALOAD:
                eb.statements.add(handleArrayIndexException("_AALoad(env,_stack,&_index)", false));
                break;
            case BALOAD:
                eb.statements.add(handleArrayIndexException("_BALoad(env,_stack,&_index)", false));
                break;
            case CALOAD:
                eb.statements.add(handleArrayIndexException("_CALoad(env,_stack,&_index)", false));
                break;
            case SALOAD:
                eb.statements.add(handleArrayIndexException("_SALoad(env,_stack,&_index)", false));
                break;
            case IASTORE:
                eb.statements.add(handleArrayIndexException("_IAStore(env,_stack,&_index);", false));
                break;
            case LASTORE:
                eb.statements.add(handleArrayIndexException("_LAStore(env,_stack,&_index);", false));
                break;
            case FASTORE:
                eb.statements.add(handleArrayIndexException("_FAStore(env,_stack,&_index);", false));
                break;
            case DASTORE:
                eb.statements.add(handleArrayIndexException("_DAStore(env,_stack,&_index);", false));
                break;
            case AASTORE:
                eb.statements.add(handleArrayIndexException("_AAStore(env,_stack,&_index)", true));
                break;
            case BASTORE:
                eb.statements.add(handleArrayIndexException("_BAStore(env,_stack,&_index);", false));
                break;
            case CASTORE:
                eb.statements.add(handleArrayIndexException("_CAStore(env,_stack,&_index);", false));
                break;
            case SASTORE:
                eb.statements.add(handleArrayIndexException("_SAStore(env,_stack,&_index);", false));
                break;
            case POP:
                eb.statements.add("pop(_stack,&_index);");
                break;
            case POP2:
                eb.statements.add("pop2(_stack,&_index);");
                break;
            case DUP_X1:
                eb.statements.add("dupx1(_stack,&_index);");
                break;
            case DUP_X2:
                eb.statements.add("dupx2(_stack,&_index);");
                break;
            case DUP2:
                eb.statements.add("dup2java(_stack,&_index);");
                break;
            case DUP2_X1:
                eb.statements.add("dup2x1(_stack,&_index);");
                break;
            case DUP2_X2:
                eb.statements.add("dup2x2(_stack,&_index);");
                break;
            case SWAP:
                eb.statements.add("swap(_stack,&_index);");
                break;
            case IADD:
                eb.statements.add("_IAdd(_stack,&_index);");
                break;
            case LADD:
                eb.statements.add("_LAdd(_stack,&_index);");
                break;
            case FADD:
                eb.statements.add("_FAdd(_stack,&_index);");
                break;
            case DADD:
                eb.statements.add("_DAdd(_stack,&_index);");
                break;
            case ISUB:
                eb.statements.add("_ISub(_stack,&_index);");
                break;
            case LSUB:
                eb.statements.add("_LSub(_stack,&_index);");
                break;
            case FSUB:
                eb.statements.add("_FSub(_stack,&_index);");
                break;
            case DSUB:
                eb.statements.add("_DSub(_stack,&_index);");
                break;
            case IMUL:
                eb.statements.add("_IMul(_stack,&_index);");
                break;
            case LMUL:
                eb.statements.add("_LMul(_stack,&_index);");
                break;
            case FMUL:
                eb.statements.add("_FMul(_stack,&_index);");
                break;
            case DMUL:
                eb.statements.add("_DMul(_stack,&_index);");
                break;
            case IDIV:
                eb.statements.add(handleSystemException("_IDiv(_stack,&_index)", ArithmeticException.class));
                break;
            case LDIV:
                eb.statements.add(handleSystemException("_LDiv(_stack,&_index)", ArithmeticException.class));
                break;
            case FDIV:
                eb.statements.add("_FDiv(_stack,&_index);");
                break;
            case DDIV:
                eb.statements.add("_DDiv(_stack,&_index);");
                break;
            case IREM:
                eb.statements.add(handleSystemException("_IRem(_stack,&_index)", ArithmeticException.class));
                break;
            case LREM:
                eb.statements.add(handleSystemException("_LRem(_stack,&_index)", ArithmeticException.class));
                break;
            case FREM:
                eb.statements.add("_FRem(_stack,&_index);");
                break;
            case DREM:
                eb.statements.add("_DRem(_stack,&_index);");
                break;
            case INEG:
                eb.statements.add("_INeg(_stack,&_index);");
                break;
            case LNEG:
                eb.statements.add("_LNeg(_stack,&_index);");
                break;
            case FNEG:
                eb.statements.add("_FNeg(_stack,&_index);");
                break;
            case DNEG:
                eb.statements.add("_DNeg(_stack,&_index);");
                break;
            case ISHL:
                eb.statements.add("_IShl(_stack,&_index);");
                break;
            case LSHL:
                eb.statements.add("_LShl(_stack,&_index);");
                break;
            case ISHR:
                eb.statements.add("_IShr(_stack,&_index);");
                break;
            case LSHR:
                eb.statements.add("_LShr(_stack,&_index);");
                break;
            case IUSHR:
                eb.statements.add("_IUShr(_stack,&_index);");
                break;
            case LUSHR:
                eb.statements.add("_LUShr(_stack,&_index);");
                break;
            case IAND:
                eb.statements.add("_IAnd(_stack,&_index);");
                break;
            case LAND:
                eb.statements.add("_LAnd(_stack,&_index);");
                break;
            case IOR:
                eb.statements.add("_IOr(_stack,&_index);");
                break;
            case LOR:
                eb.statements.add("_LOr(_stack,&_index);");
                break;
            case IXOR:
                eb.statements.add("_IXor(_stack,&_index);");
                break;
            case LXOR:
                eb.statements.add("_LXor(_stack,&_index);");
                break;
            case I2L:
                eb.statements.add("_int2long(_stack,&_index);");
                break;
            case I2F:
                eb.statements.add("_int2float(_stack,&_index);");
                break;
            case I2D:
                eb.statements.add("_int2double(_stack,&_index);");
                break;
            case L2I:
                eb.statements.add("_long2int(_stack,&_index);");
                break;
            case L2F:
                eb.statements.add("_long2float(_stack,&_index);");
                break;
            case L2D:
                eb.statements.add("_long2double(_stack,&_index);");
                break;
            case F2I:
                eb.statements.add("_float2int(_stack,&_index);");
                break;
            case F2L:
                eb.statements.add("_float2long(_stack,&_index);");
                break;
            case F2D:
                eb.statements.add("_float2double(_stack,&_index);");
                break;
            case D2I:
                eb.statements.add("_double2int(_stack,&_index);");
                break;
            case D2L:
                eb.statements.add("_double2long(_stack,&_index);");
                break;
            case D2F:
                eb.statements.add("_double2float(_stack,&_index);");
                break;
            case I2B:
                eb.statements.add("_int2byte(_stack,&_index);");
                break;
            case I2C:
                eb.statements.add("_int2char(_stack,&_index);");
                break;
            case I2S:
                eb.statements.add("_int2short(_stack,&_index);");
                break;
            case LCMP:
                eb.statements.add("lcmp(_stack,&_index);");
                break;
            case FCMPL:
                eb.statements.add("fcmpl(_stack,&_index);");
                break;
            case FCMPG:
                eb.statements.add("fcmpg(_stack,&_index);");
                break;
            case DCMPL:
                eb.statements.add("dcmpl(_stack,&_index);");
                break;
            case DCMPG:
                eb.statements.add("dcmpg(_stack,&_index);");
                break;
            case ARETURN:
                eb.statements.add("ARETURN_SET;");
                eb.returnType = 'A';
                break;
            case IRETURN:
                eb.statements.add("IRETURN_SET;");
                eb.returnType = 'I';
                break;
            case LRETURN:
                eb.statements.add("LRETURN_SET;");
                eb.returnType = 'L';
                break;
            case FRETURN:
                eb.statements.add("FRETURN_SET;");
                eb.returnType = 'F';
                break;
            case DRETURN:
                eb.statements.add("DRETURN_SET;");
                eb.returnType = 'D';
                break;
            case RETURN:
                eb.statements.add("VRETURN_SET;");
                eb.returnType = 'V';
                break;
            case ARRAYLENGTH:
                eb.statements.add(handleSystemException("_Arraylength(env,_stack,&_index)",
                        NullPointerException.class));
                break;
            case ATHROW:
                eb.statements.add(handleSystemException("_ThrowFromUser(env,_stack,&_index)",
                        NullPointerException.class));
                eb.statements.add(ExtractedBytecode.POSTPROCESS_IS_CATCHED);
                break;
            case MONITORENTER:
                eb.statements.add("_MonitorEnter(env,_stack,&_index);");
                break;
            case MONITOREXIT:
                eb.statements.add("_MonitorExit(env,_stack,&_index);");
                break;

            case DUP:
                if (!processingNew) {
                    eb.statements.add("dupjava(_stack,&_index);");
                } else {
                    this.processingNew = false;
                }
                break;
            default:
                throw new IllegalPatternError("Unimplemented opcode: " + opcode);
        }
    }

    @Override
    public void visitIntInsn(int opcode, int operand) {
        switch (opcode) {
            case BIPUSH:
            case SIPUSH:
                eb.statements.add("pushi(_stack,&_index," + operand + ");");
                break;
            case NEWARRAY: {
                switch (operand) {
                    case T_BOOLEAN:
                        eb.statements.add(handleSystemException("_NewBooleanArray(env,_stack,&_index)",
                                NegativeArraySizeException.class));
                        break;
                    case T_CHAR:
                        eb.statements.add(handleSystemException("_NewCharArray(env,_stack,&_index)",
                                NegativeArraySizeException.class));
                        break;
                    case T_FLOAT:
                        eb.statements.add(handleSystemException("_NewFloatArray(env,_stack,&_index)",
                                NegativeArraySizeException.class));
                        break;
                    case T_DOUBLE:
                        eb.statements.add(handleSystemException("_NewDoubleArray(env,_stack,&_index)",
                                NegativeArraySizeException.class));
                        break;
                    case T_BYTE:
                        eb.statements.add(handleSystemException("_NewByteArray(env,_stack,&_index)",
                                NegativeArraySizeException.class));
                        break;
                    case T_SHORT:
                        eb.statements.add(handleSystemException("_NewShortArray(env,_stack,&_index)",
                                NegativeArraySizeException.class));
                        break;
                    case T_INT:
                        eb.statements.add(handleSystemException("_NewIntArray(env,_stack,&_index)",
                                NegativeArraySizeException.class));
                        break;
                    case T_LONG:
                        eb.statements.add(handleSystemException("_NewLongArray(env,_stack,&_index)",
                                NegativeArraySizeException.class));
                        break;
                    default:
                        throw new IllegalPatternError("Unimplemented opcode: NEWARRAY with type " + operand);
                }
            }
            break;
            default:
                throw new IllegalPatternError("Unimplemented opcode: " + opcode);
        }
    }

    @Override
    public void visitLdcInsn(Object cst) {
        Class cls = cst.getClass();
        switch (cls.getName()) {
            case "java.lang.Integer":
                eb.statements.add("pushi(_stack,&_index," + cst + ");");
                break;
            case "java.lang.Long":
                eb.statements.add("pushl(_stack,&_index," + cst + "LL);");
                break;
            case "java.lang.Float": {
                Float value = (Float) cst;
                if (value.isNaN()) {
                    eb.statements.add("pushf(_stack,&_index,(float)NAN);");
                } else if (value.equals(Float.POSITIVE_INFINITY)) {
                    eb.statements.add("pushf(_stack,&_index,(float)INFINITY);");
                } else if (value.equals(Float.NEGATIVE_INFINITY)) {
                    eb.statements.add("pushf(_stack,&_index,(float)-INFINITY);");
                } else {
                    eb.statements.add("pushf(_stack,&_index," + cst + "f);");
                }
                break;
            }
            case "java.lang.Double": {
                Double value = (Double) cst;
                if (value.isNaN()) {
                    eb.statements.add("pushd(_stack,&_index,NAN);");
                } else if (value.equals(Double.POSITIVE_INFINITY)) {
                    eb.statements.add("pushd(_stack,&_index,INFINITY);");
                } else if (value.equals(Double.NEGATIVE_INFINITY)) {
                    eb.statements.add("pushd(_stack,&_index,-INFINITY);");
                } else {
                    eb.statements.add("pushd(_stack,&_index," + cst + ");");
                }
                break;
            }
            case "java.lang.String": {
                String str = (String) cst;
                int stringID = this.countStrings++;
                eb.statements.add("jchar string_" + stringID + "[" + str.length() + "];");
                for (int i = 0; i < str.length(); i++) {
                    eb.statements.add("string_" + stringID + "[" + i + "]=" + (short) str.charAt(i) + ";");
                }
                eb.statements.add("_Ldc(env,_stack,&_index,string_" + stringID + "," + str.length() + ");");
                break;
            }
            default:
                throw new IllegalPatternError("Unimplemented opcode: LDC for object" + cst.getClass().getCanonicalName());
        }
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        MethodSignature signature = new MethodSignature(desc);
        String argumentsName = "function_vals" + countFunctions++;
        JniType currentType;
        StringBuilder statementBuilder = new StringBuilder();
        eb.statements.add("jvalue " + argumentsName + "[" + signature.getInput().size() + "];");
        for (int i = signature.getInput().size() - 1; i >= 0; i--) {
            //EXAMPLE RESULT OF THE STRING BUILDER:
            //function_vals0[1] = pop(_stack,&_index);
            statementBuilder.setLength(0);
            currentType = signature.getInput().get(i);
            statementBuilder.append(argumentsName).append("[").append(i).append("]=");
            //pop2 only if double length AND NOT AN ARRAY!!!
            if (currentType.isDoubleLength() && !currentType.getJniName().equals("jobject")) {
                statementBuilder.append("pop2(_stack,&_index);");
            } else {
                statementBuilder.append("pop(_stack,&_index);");
            }
            eb.statements.add(statementBuilder.toString());
        }
        switch (opcode) {
            case INVOKEINTERFACE:
            case INVOKEVIRTUAL:
                eb.statements.add("_InvokeVirtual_" + signature.getReturnType().getJniName() + "(env,_stack,&_index," +
                        "\"" +
                        owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");
                eb.statements.add("if((*env)->ExceptionCheck(env)){\n_ThrowFromJVM(env,_stack,&_index);");
                eb.statements.add(ExtractedBytecode.POSTPROCESS_EXCEPTION_CLEAR);
                eb.statements.add("}");
                break;
            case INVOKESPECIAL:
                if (!name.equals("<init>")) {
                    eb.statements.add("_InvokeSpecial_" + signature.getReturnType().getJniName() + "(env,_stack," +
                            "&_index,\"" +
                            owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");
                } else {
                    eb.statements.add("_New(env,_stack,&_index,\"" + owner + "\",\"" + desc + "\"," + argumentsName + ");");
                }
                eb.statements.add("if((*env)->ExceptionCheck(env)){\n_ThrowFromJVM(env,_stack,&_index);");
                eb.statements.add(ExtractedBytecode.POSTPROCESS_EXCEPTION_CLEAR);
                eb.statements.add("}");
                break;
            case INVOKESTATIC:
                eb.statements.add("_InvokeStatic_" + signature.getReturnType().getJniName() + "(env,_stack,&_index,\"" +
                        owner + "\",\"" + name + "\",\"" + desc + "\"," + argumentsName + ");");
                eb.statements.add("if((*env)->ExceptionCheck(env)){\n_ThrowFromJVM(env,_stack,&_index);");
                eb.statements.add(ExtractedBytecode.POSTPROCESS_EXCEPTION_CLEAR);
                eb.statements.add("}");
                break;
            default:
                throw new IllegalPatternError("Unimplemented opcode: " + opcode);
        }
    }

    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        JniType type = new JniType(desc);
        switch (opcode) {
            case GETFIELD:
                eb.statements.add(handleSystemException("_GetField_" + type.getJniName() + "(env,_stack,&_index,\"" +
                        owner + "\",\"" + name + "\",\"" + desc + "\")", NullPointerException.class));
                break;
            case GETSTATIC:
                eb.statements.add("_GetStatic_" + type.getJniName() + "(env,_stack,&_index,\"" + owner + "\",\"" +
                        name + "\",\"" + desc + "\");");
                break;
            case PUTFIELD:
                eb.statements.add(handleSystemException("_SetField_" + type.getJniName() + "(env,_stack,&_index,\"" +
                        owner + "\",\"" + name + "\",\"" + desc + "\")", NullPointerException.class));
                break;
            case PUTSTATIC:
                eb.statements.add("_SetStatic_" + type.getJniName() + "(env,_stack,&_index,\"" + owner + "\",\"" +
                        name + "\",\"" + desc + "\");");
                break;
            default:
                throw new IllegalPatternError("Unimplemented opcode: " + opcode);
        }
    }

    @Override
    public void visitTypeInsn(int opcode, String type) {
        switch (opcode) {
            case NEW:
                processingNew = true;
                break;
            case ANEWARRAY:
                eb.statements.add(handleSystemException("_NewObjectArray(env,_stack,&_index,\"" + type + "\")",
                        NegativeArraySizeException.class));
                break;
            case INSTANCEOF:
                eb.statements.add("_InstanceOf(env,_stack,&_index,\"" + type + "\");");
                break;
            case CHECKCAST:
                eb.statements.add(handleSystemException("_CheckCast(env,_stack,&_index,\"" + type + "\")",
                        ClassCastException.class));
                break;

            default:
                throw new IllegalPatternError("Unimplemented opcode: " + opcode);
        }
    }

    @Contract(pure = true)
    private String handleArrayIndexException(String stmt, boolean isAASTORE) {
        //visit the entire tree and search if the exception was catched
        String retval = "retcode=" + stmt + ";\n" +
                "if(retcode==1){\n" + //handle ArrayIndexOutOfBoundsException
                "_ThrowFromJNI(env,_stack,&_index,\"java/lang/ArrayIndexOutOfBoundsException\");\n" +
                "#ifdef CATCH_java_lang_ArrayIndexOutOfBoundsException\n" +
                "goto CATCH_java_lang_ArrayIndexOutOfBoundsException;\n" +
                "#elif defined(CATCH_java_lang_IndexOutOfBoundsException)\n" +
                "goto CATCH_java_lang_IndexOutOfBoundsException;\n" +
                "#elif defined(CATCH_java_lang_RuntimeException)\n" +
                "goto CATCH_java_lang_RuntimeException;\n" +
                "#elif defined(CATCH_java_lang_Exception)\n" +
                "goto CATCH_java_lang_Exception;\n" +
                "#elif defined(CATCH_java_lang_Throwable)\n" +
                "goto CATCH_java_lang_Throwable;\n" +
                "#elif defined(CATCH_java_lang_Object)\n" +
                "goto CATCH_java_lang_Object;\n" +
                "#else\n" +
                "(*env)->Throw(env,_stack[0].l);\n" +
                "RETURN_EXCEPTION;\n" +
                "#endif\n" +
                "}\n" +
                "else if(retcode==2){\n" + //handle NullPointerException
                "_ThrowFromJNI(env,_stack,&_index,\"java/lang/NullPointerException\");\n" +
                "#ifdef CATCH_java_lang_NullPointerException\n" +
                "goto CATCH_java_lang_NullPointerException;\n" +
                "#elif defined(CATCH_java_lang_RuntimeException)\n" +
                "goto CATCH_java_lang_RuntimeException;\n" +
                "#elif defined(CATCH_java_lang_Exception)\n" +
                "goto CATCH_java_lang_Exception;\n" +
                "#elif defined(CATCH_java_lang_Throwable)\n" +
                "goto CATCH_java_lang_Throwable;\n" +
                "#elif defined(CATCH_java_lang_Object)\n" +
                "goto CATCH_java_lang_Object;\n" +
                "#else\n" +
                "(*env)->Throw(env,_stack[0].l);\n" +
                "RETURN_EXCEPTION;\n" +
                "#endif\n" +
                "}\n";
        if (isAASTORE) {
            retval += "else if(retcode==3){\n" + //handle ArrayStoreException
                    "_ThrowFromJNI(env,_stack,&_index,\"java/lang/ArrayStoreException\");\n" +
                    "#ifdef CATCH_java_lang_ArrayStoreException\n" +
                    "goto CATCH_java_lang_ArrayStoreException;\n" +
                    "#elif defined(CATCH_java_lang_RuntimeException)\n" +
                    "goto CATCH_java_lang_RuntimeException;\n" +
                    "#elif defined(CATCH_java_lang_Exception)\n" +
                    "goto CATCH_java_lang_Exception;\n" +
                    "#elif defined(CATCH_java_lang_Throwable)\n" +
                    "goto CATCH_java_lang_Throwable;\n" +
                    "#elif defined(CATCH_java_lang_Object)\n" +
                    "goto CATCH_java_lang_Object;\n" +
                    "#else\n" +
                    "(*env)->Throw(env,_stack[0].l);\n" +
                    "RETURN_EXCEPTION;\n" +
                    "#endif\n" +
                    "}\n";
        }
        return retval;
    }

    @NotNull
    private String handleSystemException(String stmt, @NotNull Class<?> excpName) {
        String exception = excpName.getName().replaceAll("\\.", "_");
        String className = excpName.getName().replaceAll("\\.", "/");
        return "if(" + stmt + "){\n" +
                "_ThrowFromJNI(env,_stack,&_index,\"" + className + "\");\n" +
                "#ifdef CATCH_" + exception + "\n" +
                "goto CATCH_" + exception + ";\n" +
                "#elif defined(CATCH_java_lang_RuntimeException)\n" +
                "goto CATCH_java_lang_RuntimeException;\n" +
                "#elif defined(CATCH_java_lang_Exception)\n" +
                "goto CATCH_java_lang_Exception;\n" +
                "#elif defined(CATCH_java_lang_Throwable)\n" +
                "goto CATCH_java_lang_Throwable;\n" +
                "#elif defined(CATCH_java_lang_Object)\n" +
                "goto CATCH_java_lang_Object;\n" +
                "#else\n" +
                "(*env)->Throw(env,_stack[0].l);\n" +
                "RETURN_EXCEPTION;\n" +
                "#endif\n" +
                "}\n";

    }
}