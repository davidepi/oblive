package eu.fbk.hardening.performance.stack;

import eu.fbk.hardening.helpers.AbstractTestPerformanceTemplate;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class TestIConst extends AbstractTestPerformanceTemplate {
    @Override
    public String getClassName() {
        return this.getClass().getPackage().getName()+".IConstPerformance";
    }

    @Override
    public void pattern(@NotNull MethodVisitor mv) {
        mv.visitInsn(Opcodes.ICONST_0);
    }

    @Override
    public int numberOfRepetitions() {
        return 10;
    }
}
