package it.se.callgraph.obfuscator;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import static jdk.internal.org.objectweb.asm.Opcodes.ACC_NATIVE;
import static jdk.internal.org.objectweb.asm.Opcodes.ASM5;

public class ClassExplorer extends ClassVisitor
{
    private String output;

    public ClassExplorer(ClassVisitor cv, String out)
    {
        super(ASM5,cv);
        this.output = out;
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exception)
    {
        MethodVisitor mv = cv.visitMethod(access,name,desc,signature,exception);
        if(mv!=null)
        {

            AnnotatedMethodExplorer ame = new AnnotatedMethodExplorer(mv,name+signature);
            if(ame.shouldObfuscate())
            {
                try
                {
                    PrintWriter out = new PrintWriter(this.output);
                    out.write(ame.getBytecode());
                    out.close();
                } catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                return cv.visitMethod(access | ACC_NATIVE, name, desc, signature, exception);
            }
        }
        return mv;
    }
}
