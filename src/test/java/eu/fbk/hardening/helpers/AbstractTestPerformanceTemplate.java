package eu.fbk.hardening.helpers;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import eu.fbk.hardening.support.NativeCompiler;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Template used to test the correctness of the transformed (obfuscated) method.
 * In this case the transformed method must:
 * <ol>
 * <li>Yields the same result of the non-transformed method</li>
 * <li>The <b>code</b> is changed only in transformed methods</li>
 * <li>The <b>annotation</b> is changed only in transformed methods</li>
 * </ol>
 * <p>
 * For the point 2. above, note that the <tt>&lt;clinit&gt;</tt> method actually is changed in order to link the library. The
 * check for unchanged code explicitly avoids checking <tt>&lt;clinit&gt;</tt>.
 *
 * @author M.Ceccato
 * @author D.Pizzolotto
 */
public abstract class AbstractTestPerformanceTemplate extends Java2CTests {

    /**
     * Checks the time required to run a set of opcodes
     */
    @Test
    public void testPerformance() {

        //write the .class file
        try {
            emitter();
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }

        String libname = getClassName().replaceFirst("class\\s", "");
        String name = libname.replaceAll("\\.", "/") + ".class";
        //transform it
        transformJava2C(name, libname);

        try {
            //profile the generated .c file
            profileFile(libname);
        } catch (IOException e) {
            Assertions.fail("Profilation impossible");
            e.printStackTrace();
        }

        //compile it by setting ad-hoc flags
        NativeCompiler compiler = new NativeCompiler();
        compiler.overrideFlags("-fauto-inc-dec " +
                "-fbranch-count-reg " +
                "-fcombine-stack-adjustments " +
                "-fcompare-elim " +
                "-fcprop-registers " +
                "-fdefer-pop " +
                "-fdelayed-branch " +
                "-fforward-propagate " +
                "-fguess-branch-probability " +
                "-fif-conversion " +
                "-fif-conversion2 " +
                "-finline-functions-called-once " +
                "-fipa-profile " +
                "-fipa-pure-const " +
                "-fipa-reference " +
                "-fmerge-constants " +
                "-fmove-loop-invariants " +
                "-fomit-frame-pointer " +
                "-freorder-blocks " +
                "-fshrink-wrap " +
                "-fshrink-wrap-separate " +
                "-fsplit-wide-types " +
                "-fssa-backprop " +
                "-fssa-phiopt " +
                "-ftree-bit-ccp " +
                "-ftree-ccp " +
                "-ftree-ch " +
                "-ftree-coalesce-vars " +
                "-ftree-copy-prop " +
                "-ftree-dominator-opts " +
                "-ftree-forwprop " +
                "-ftree-fre " +
                "-ftree-phiprop " +
                "-ftree-pta " +
                "-ftree-scev-cprop " +
                "-ftree-sink " +
                "-ftree-slsr " +
                "-ftree-sra " +
                "-ftree-ter " +
                "-funit-at-a-time " +
                //O2
                "-falign-functions " +
                "-falign-jumps " +
                "-falign-labels " +
                "-falign-loops " +
                "-fcaller-saves " +
                "-fcode-hoisting " +
                "-fcrossjumping " +
                "-fcse-follow-jumps " +
                "-fcse-skip-blocks " +
                "-fdelete-null-pointer-checks " +
                "-fdevirtualize " +
                "-fdevirtualize-speculatively " +
                "-fexpensive-optimizations " +
                "-fhoist-adjacent-loads " +
                "-finline-small-functions " +
                "-findirect-inlining " +
                "-fipa-bit-cp  " +
                "-fipa-cp " +
                "-fipa-icf " +
                "-fipa-ra " +
                "-fipa-sra " +
                "-fipa-vrp " +
                "-fisolate-erroneous-paths-dereference " +
                "-flra-remat " +
                "-foptimize-sibling-calls " +
                "-foptimize-strlen " +
                "-fpartial-inlining " +
                "-fpeephole2 " +
                "-freorder-blocks-algorithm=stc " +
                "-freorder-blocks-and-partition  " +
                "-freorder-functions " +
                "-frerun-cse-after-loop  " +
                "-fschedule-insns  " +
                "-fschedule-insns2 " +
                "-fsched-interblock  " +
                "-fsched-spec " +
                "-fstore-merging " +
                "-fstrict-aliasing " +
                "-fthread-jumps " +
                "-ftree-builtin-call-dce " +
                "-ftree-pre " +
                "-ftree-switch-conversion  " +
                "-ftree-tail-merge " +
                "-ftree-vrp " +
                //O3
                "-finline-functions " +
                "-fipa-cp-clone " +
                "-floop-interchange " +
                "-floop-unroll-and-jam " +
                "-fpeel-loops " +
                "-fpredictive-commoning " +
                "-fsplit-paths " +
                "-ftree-loop-distribute-patterns " +
                "-ftree-loop-distribution " +
                "-ftree-loop-vectorize " +
                "-ftree-partial-pre " +
                "-ftree-slp-vectorize " +
                "-funswitch-loops " +
                "-fvect-cost-model ");
        buildJava2C(libname, compiler);

        //load it and run it n times
        try {
            ArrayList<Double> results = new ArrayList<>(executionRepetitions());
            Class clazz = TestUtils.loadClass(getDestDir(), getClassName());
            Object target = clazz.newInstance();
            for (int i = 0; i < executionRepetitions(); i++) {
                Object res = TestUtils.runCode(target, getTestMethodName(), getTestMethodParams(), getTestMethodParams())[0];
                if (res instanceof Double) {
                    double currentTime = (Double) res;
                    afterSingleRepetition(currentTime);
                    results.add(currentTime);
                } else
                    Assertions.fail("Unexpected return value: " + res.getClass());
            }
            saveMeasurements(results);
        } catch (ClassNotFoundException | IOException | InstantiationException | NoSuchMethodException | IllegalAccessException e) {
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Function that will be invoked after each repetition of the
     *
     * @param time The time required in order to run the pattern() opcodes once, in nanoseconds
     */
    public void afterSingleRepetition(double time) {

    }

    /**
     * Function that will be called after all the repetitions and saves all the time values collected into
     * build/reports/tests/performance
     *
     * @param results the time required to run the pattern() of every repetition, in nanoseconds
     */
    public void saveMeasurements(ArrayList<Double> results) {
        File f = new File("build/reports/tests/performance/" + getClassName().substring(getClassName().lastIndexOf(".") + 1) + ".csv");
        f.getParentFile().mkdirs();
        try {
            FileOutputStream fout = new FileOutputStream(f);
            PrintWriter pw = new PrintWriter(fout);
            pw.println("Time(ns)");
            for (double result : results) {
                pw.println(result);
            }
            pw.close();
        } catch (IOException ignored) {
        }
    }

    /**
     * Returns the number of repetition of the pattern, in the actual Java code
     *
     * @return how many times the pattern should be repeated in the emitted code in order
     */
    public int patternRepetitions() {
        return 1;
    }

    /**
     * Returns the number of executions performed, in order to get a better statistical representation
     *
     * @return The number of executions of the performance measurements, without the compilation
     */
    public int executionRepetitions() {
        return 1;
    }

    /**
     * How many opcodes are left uncleaned on the stack after every pattern repetition.
     * This is used to craft the correct stack size with the formula pollution*repetitions
     *
     * @return The number of garbage left uncleaned onto the stack after every repetition
     */
    public int stackPollution() {
        return 0;
    }

    /**
     * Returns the fully qualified class name that will be emitted. This should be in the form java.lang.String
     *
     * @return the name of the class that will be emitted
     */
    //note that this is not a getter for the field classname, but the opposite: that field is built upon this method
    public abstract String getClassName();

    /**
     * The pattern that will be evaluated. This pattern is emitted patternRepetitions() times.
     * This should be implemented by calling the various visitInsn with the MethodVisitor received as parameter
     *
     * @param mv The MethodVisitor that will visit the various instructions
     */
    public abstract void pattern(MethodVisitor mv);

    /**
     * Opcodes that will be emitted before the actual pattern. Like a sort of initialization. These opcodes will not
     * be evaluated in term of time.
     * This should be implemented by calling the various visitInsn with the MethodVisitor received as parameter
     *
     * @param mv The MethodVisitor that will visit the various instructions
     */
    public void beforePattern(final @NotNull MethodVisitor mv) {
    }

    /**
     * Opcodes that will be emitted after the actual pattern. This is a sort of cleanup. These opcodes will not count
     * in term of time
     * This should be implemented by calling the various visitInsn with the MethodVisitor received as parameter
     *
     * @param mv The MethodVisitor that will visit the various instructions
     */
    public void afterPattern(final @NotNull MethodVisitor mv) {
    }

    private void emitter() throws IOException {

        String className = getClassName().replaceAll("\\.", "/");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER, className, null, "java/lang/Object", null);
        cw.visitSource(className.substring(className.lastIndexOf(".") + 1), null);

        //generate constructor
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        Label label0 = new Label();
        mv.visitLabel(label0);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(Opcodes.RETURN);
        Label label1 = new Label();
        mv.visitLabel(label1);
        mv.visitLocalVariable("this", "L" + className + ";", null, label0, label1, 0);
        mv.visitEnd();

        //generate tested method
        mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "test", "()D", null, null);
        //generate annotation
        AnnotationVisitor av = mv.visitAnnotation("L" + Obfuscation.class.getName().replace('.', '/') + ";", true);
        av.visitEnum("protections", "L" + Protections.class.getName().replaceAll("\\.", "/") + ";", Protections.TO_NATIVE_CODE.toString());
        av.visitEnd();

        mv.visitCode();
        Label labelStart = new Label();
        mv.visitLabel(labelStart);
        beforePattern(mv);
        mv.visitInsn(Opcodes.NOP); //first NOP, start profilation
        for (int i = 0; i < patternRepetitions(); i++) {
            pattern(mv);
        }
        mv.visitInsn(Opcodes.NOP); //second NOP, end profilation
        afterPattern(mv);
        //this value will be popped and replaced with the obtained time. It is here so ASM can compute the frames
        mv.visitInsn(Opcodes.DCONST_0);
        mv.visitInsn(Opcodes.NOP); //third NOP, pop DCONST_0 from stack and push the time
        mv.visitInsn(Opcodes.DRETURN);
        Label labelEnd = new Label();
        mv.visitLabel(labelEnd);
        mv.visitLocalVariable("this", "L" + className + ";", null, labelStart, labelEnd, 0);
        mv.visitEnd();
        mv.visitMaxs(10 + stackPollution() * patternRepetitions(), 10);
        cw.visitEnd();

        File f = new File(getDestDir() + File.separator + className + ".class");
        f.getParentFile().mkdirs();
        FileOutputStream outputClass = new FileOutputStream(f);
        outputClass.write(cw.toByteArray());
        outputClass.close();
    }

    /**
     * Replace the various NOP instructions generated by the emitter() with profilation instructions
     *
     * @param libname The name of the library that will be outputted
     * @throws IOException if the .c file can not be found
     */
    private void profileFile(String libname) throws IOException {
        Path path = Paths.get(OUTPUT_LIB_DIR + File.separator + libname + ".c");
        Charset charset = StandardCharsets.US_ASCII;

        String content = new String(Files.readAllBytes(path), charset)
                .replaceFirst("#define NOP", "#include <time.h>")
                .replaceFirst("NOP;", "struct timespec time0;\nstruct timespec time1;\nclock_gettime(CLOCK_PROCESS_CPUTIME_ID, &time0);")
                .replaceFirst("NOP;", "clock_gettime(CLOCK_PROCESS_CPUTIME_ID, &time1);")
                .replaceFirst("NOP;", "pop2(_stack,&_index);\npushd(_stack,&_index,diff(time0,time1).tv_nsec);");
        Files.write(path, content.getBytes(charset));
    }

    @Override
    public Class<?> getTestClass() {
        return null;
    }

    @Override
    public String[] getTestMethodName() {
        return new String[]{"test"};
    }

    @Override
    public Class<?>[][] getTestMethodParams() {
        return new Class[][]{new Class[0]};
    }

    @Override
    public Object[][] getTestMethodArgs() {
        return new Object[][]{new Object[0]};
    }
}
