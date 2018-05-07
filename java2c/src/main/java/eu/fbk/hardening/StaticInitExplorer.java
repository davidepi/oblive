package eu.fbk.hardening;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class StaticInitExplorer extends MethodVisitor
{
    private String className;

    public StaticInitExplorer(MethodVisitor mv,String className)
    {
        super(ASM5,mv);
        this.className = className.replace('/','.');
    }

    @Override
    public void visitInsn(int opcode)
    {
        //TODO: dentro la visit code
        //end of the static block
        if(opcode == RETURN)
        {
            super.visitLdcInsn(className);
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
