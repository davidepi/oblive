package it.se.obfuscator;


import it.se.obfuscator.support.ClassMethodPair;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

import static org.objectweb.asm.Opcodes.*;

public class ClassCodeEliminator extends ClassVisitor
{
    private ArrayList<ClassMethodPair> toObfuscate;
    private String className;
    private String libname;
    private boolean hasStaticInit;

    public ClassCodeEliminator(ArrayList<ClassMethodPair> obfuscateme, String libname, ClassWriter cw)
    {
        super(ASM5,cw);
        this.toObfuscate = obfuscateme;
        this.hasStaticInit = false;
        this.libname = libname;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
    {
        this.className = name;
        super.visit(version,access,name,signature,superName,interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
    {
        //static init, special case
        if(name.equals("<clinit>") && desc.equals("()V"))
        {
            hasStaticInit = true;
            //add the library import while visiting static init
            MethodVisitor mv = super.visitMethod(access,name,desc,signature,exceptions);
            return new StaticInitExplorer(mv,className);
        }

        //check if obfuscated
        for(int i=0;i<toObfuscate.size();i++)
        {
            ClassMethodPair cmp = toObfuscate.get(i);
            if(desc.equals(cmp.getDesc()) && name.equals(cmp.getMethodName())&&
                    this.className.equals((cmp.getClassName()))) //check if method has to be obfuscated
            {
                //alter the method declaration by adding native
                super.visitMethod(access | ACC_NATIVE,name,desc,signature,exceptions);
                //but return empty body
                return null;
            }
        }

        //otherwise return the method
        return super.visitMethod(access,name,desc,signature,exceptions);
    }

    @Override
    public void visitEnd()
    {
        if(!hasStaticInit) //missing static import, craft manually
        {
            MethodVisitor mv = super.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
            mv.visitCode();
            mv.visitLdcInsn(libname);
            mv.visitMethodInsn(INVOKESTATIC,"java/lang/System","loadLibrary","(Ljava/lang/String;)V",false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1,0);
            mv.visitEnd();
        }
        super.visitEnd();
    }
}
