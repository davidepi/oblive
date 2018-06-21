package eu.fbk.hardening;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

public class StaticInitExplorer extends MethodVisitor
{
    private String libname;

    public StaticInitExplorer(MethodVisitor mv,String libname)
    {
        super(ASM5,mv);
        this.libname = libname.replace('/','.');
    }

    @Override
    public void visitInsn(int opcode)
    {
        //TODO: dentro la visit code
        //end of the static block
        if(opcode == RETURN)
        {
            super.visitLdcInsn(libname);
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
