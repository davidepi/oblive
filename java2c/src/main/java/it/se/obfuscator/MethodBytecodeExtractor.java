package it.se.obfuscator;

import it.se.obfuscator.support.ExtractedBytecode;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class MethodBytecodeExtractor extends MethodVisitor
{
    ExtractedBytecode eb;

    public MethodBytecodeExtractor(boolean isStatic)
    {
        super(ASM5);
        eb = new ExtractedBytecode(isStatic);
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
}
