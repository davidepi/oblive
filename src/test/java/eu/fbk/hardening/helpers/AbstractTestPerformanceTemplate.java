package eu.fbk.hardening.helpers;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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
            //profile it
            profileFile(libname);
        } catch (IOException e) {
            Assertions.fail("Profilation impossible");
            e.printStackTrace();
        }

        //compile it
        buildJava2C(libname);
        //load it and run it
        try {
            URL url = new File(getDestDir()).toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader cl = new URLClassLoader(urls);
            Class clazz = cl.loadClass(getClassName());
            Object res = TestUtils.runCode(getDestDir(), clazz, getTestMethodName(), getTestMethodParams(), getTestMethodParams())[0];
            if (res instanceof Double)
                afterTest((Double) res);
            else
                Assertions.fail("Unexpected return value: " + res.getClass());
        } catch (ClassNotFoundException | IOException | InstantiationException | NoSuchMethodException | IllegalAccessException e) {
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Function that will be invoked after measuring the time
     *
     * @param time The time required in order to run the pattern() opcodes numberOfRepetitions() times
     */
    public void afterTest(double time) {
        System.out.println(time);
    }

    /**
     * Returns the number of repetition of the pattern, in the actual Java code
     *
     * @return how many times the pattern should be repeated in the emitted code in order
     */
    public int numberOfRepetitions() {
        return 1;
    }

    /**
     * Returns the fully qualified class name that will be emitted. This should be in the form java.lang.String
     *
     * @return the name of the class that will be emitted
     */
    //note that this is not a getter for the field classname, but the opposite: that field is built upon this method
    public abstract String getClassName();

    /**
     * The pattern that will be evaluated. This pattern is emitted numberOfRepetitions() times.
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
        for (int i = 0; i < numberOfRepetitions(); i++) {
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
