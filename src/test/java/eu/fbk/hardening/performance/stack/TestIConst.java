package eu.fbk.hardening.performance.stack;

import eu.fbk.hardening.helpers.AbstractTestPerformanceTemplate;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TestIConst extends AbstractTestPerformanceTemplate {

    @Override
    public String getClassName() {
        return this.getClass().getPackage().getName() + ".IConstPerformance";
    }

    @Override
    public void pattern(@NotNull MethodVisitor mv) {
        mv.visitInsn(Opcodes.ICONST_0);
    }

    @Override
    public int patternRepetitions() {
        return 50000;
    }

    @Override
    public int executionRepetitions() {
        return 10000000;
    }
}
