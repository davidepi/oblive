package it.se.callgraph.obfuscator;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM5;

public class AnnotatedMethodExplorer extends MethodVisitor
{
    private boolean obf_annotated;
    private String methodName;

    public AnnotatedMethodExplorer(String methodName)
    {
        super(ASM5);
        this.methodName = methodName;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible)
    {
        if(desc.equals("Lit/se/jnitest/Obfuscate;"))
            this.obf_annotated = true;
        else
            this.obf_annotated = false;
        return super.visitAnnotation(desc,visible);
    }

    public boolean shouldObfuscate()
    {
        return this.obf_annotated;
    }

    public String getMethodName()
    {
        return this.methodName;
    }
}