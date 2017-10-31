package it.se.obfuscator;

import it.se.obfuscator.support.ClassMethodPair;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM5;

public class AnnotatedMethodExplorer extends MethodVisitor
{
    private boolean obf_annotated;
    private String methodName;
    private String signature;

    public AnnotatedMethodExplorer(String methodName, String signature)
    {
        super(ASM5);
        this.methodName = methodName;
        this.signature = signature;
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

    public ClassMethodPair getMethod()
    {
        return new ClassMethodPair("",methodName,signature);
    }
}