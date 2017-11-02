package it.se.obfuscator;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class StaticInitExplorer extends MethodVisitor
{
    public StaticInitExplorer(MethodVisitor mv)
    {
        super(ASM5,mv);
    }

    @Override
    public void visitInsn(int opcode)
    {
        //TODO: dentro la visit code
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
