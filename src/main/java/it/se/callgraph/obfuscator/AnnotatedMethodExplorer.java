package it.se.callgraph.obfuscator;

import jdk.internal.org.objectweb.asm.AnnotationVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM5;
import static jdk.internal.org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

public class AnnotatedMethodExplorer extends MethodVisitor
{
    boolean obf_annotated = false;
    private StringBuilder sb;

    public AnnotatedMethodExplorer(MethodVisitor mv,String method_name)
    {
        super(ASM5,mv);
        sb.append(method_name);
        sb.append('\n');
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible)
    {
        if(desc.equals("Lit/se/jnitest/Obfuscate;"))
            this.obf_annotated = true;
        return super.visitAnnotation(desc,visible);
    }

    public boolean shouldObfuscate()
    {
        return this.obf_annotated;
    }

    public String getBytecode()
    {
        return this.sb.toString();
    }

    @Override
    public void visitCode()
    {
        sb.append("{\n");
    }

    @Override
    public void visitEnd()
    {
        sb.append("}\n");
    }

    @Override

}