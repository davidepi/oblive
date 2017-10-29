package it.se.callgraph.obfuscator;

import jdk.internal.org.objectweb.asm.AnnotationVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM5;

public class AnnotatedMethodExplorer extends MethodVisitor
{
    boolean obf_annotated;
    private StringBuilder sb;

    public AnnotatedMethodExplorer(MethodVisitor mv,String method_name)
    {
        super(ASM5,mv);
        sb = new StringBuilder();
        sb.append(method_name);
        sb.append('\n');
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
    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack)
    {
        sb.append("MAX-STACK: ");
        sb.append(nStack);
        sb.append("\nMAX-VARS: ");
        sb.append(nLocal);
        sb.append('\n');
    }

    @Override
    public void visitVarInsn(int opcode, int var)
    {
        sb.append(opcode);
        sb.append(' ');
        sb.append(var);
        sb.append('\n');
    }

    @Override
    public void visitInsn(int opcode)
    {
        sb.append(opcode);
        sb.append('\n');
    }
}