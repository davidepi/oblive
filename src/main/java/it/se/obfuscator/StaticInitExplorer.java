package it.se.obfuscator;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM5;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.RETURN;

public class StaticInitExplorer extends MethodVisitor
{
    public StaticInitExplorer(MethodVisitor mv)
    {
        super(ASM5,mv);
    }

    @Override
    public void visitInsn(int opcode)
    {
        //end of the static block
        if(opcode == RETURN)
        {
            //add the library
            //TODO: change lib name?
            super.visitLdcInsn("obf");
            super.visitMethodInsn(INVOKESTATIC,"java/lang/System","loadLibrary","(Ljava/lang/String;)V",false);
        }
        super.visitInsn(opcode);
    }

    @Override
    public void visitMaxs(int maxStack, int maxVars)
    {
        //since one string will be pushed onto the stack
        super.visitMaxs(maxStack+1,maxVars);
    }
}
