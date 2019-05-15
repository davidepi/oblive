package eu.fbk.hardening.helpers;

import eu.fbk.hardening.JavaToC;
import eu.fbk.hardening.support.NativeCompiler;
import eu.fbk.hardening.support.SystemInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Abstract test class to transform a class and test the occurred transformation.
 * The method must
 * 1. The execution result has not changed
 * 2. The code has changed changed only for intended methods
 * 3. The annotation has changed only for the intended methods/fields
 *
 * @author M.Ceccato
 * @author D.Pizzolotto
 */
public abstract class AbstractTestCorrectnessTemplate implements TestInterface {

    private final String inputClassDir = "build" + File.separator + "classes" + File.separator + "java" + File.separator + "test";
    private final String copiedClassDir = "build" + File.separator + "transformedclasses";
    private final String outputLibDir = "build" + File.separator + "libsrc";
    //annotated methods
    private MethodNode[] sourceAnnotatedMethodNodes1;
    private MethodNode[] destAnnotatedMethodNodes2;

    //not-annotated methods
    private MethodNode[] sourceNotAnnotatedMethodNodes3;
    private MethodNode[] destdNotAnnotatedMethodNodes4;

    @Test
    public void testCorrectness() {
        try {
            TestUtils.copyInput(getSourceDir(), getDestDir(), getTestClass());
            transformClass();

            // run the original class
            Object[] result1 = TestUtils.runCode(null, getTestClass(), getTestMethodName(), getTestMethodParams(), getTestMethodArgs());

            // run the transformed class
            Object[] result2 = TestUtils.runCode(getDestDir(), getTestClass(), getTestMethodName(), getTestMethodParams(), getTestMethodArgs());

            // check for same results
            int length = getTestMethodName().length;
            for (int i = 0; i < length; i++) {
                String message = "method: " + getTestMethodName()[i] + ", class: " + getTestClass().getName() + " --- Different execution result";
                assertSameObj(result1[i], result2[i], message);
            }

            // check transformed methods
            sourceAnnotatedMethodNodes1 = getMethodNodesForAnnotatedMethods(getSourceDir(), getTestClass());
            destAnnotatedMethodNodes2 = getMethodNodesForAnnotatedMethods(getDestDir(), getTestClass());

            // check that transformed methods have different code before and after transformation
            checkCodeInTransformedMethods();

            // check that transformed methods have different annotations before and after transformation
            checkAnnotationsInTransformedMethods();

            // check NON-transformed methods
            sourceNotAnnotatedMethodNodes3 = getOtherMethodNodes(getSourceDir(), getTestClass(), sourceAnnotatedMethodNodes1);
            destdNotAnnotatedMethodNodes4 = getOtherMethodNodes(getDestDir(), getTestClass(), destAnnotatedMethodNodes2);

            // check that NON-transformed methods have the same code before and after transformation
            if (!changesBeyondAnnotatedMethods()) {
                checkCodeInPreservedMethods();
            }

            // check that NON-transformed methods have the same annotations before and after transformation
            checkAnnotationsInPreservedMethods();

            //check annotations has been removed on context field
            checkAnnotationInAnnotatedFields();
        } catch (IOException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            Assertions.fail(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String getAnnotatedFieldName(int position) {
        return "";
    }

    @Override
    public int getAnnotatedFieldSize() {
        return 0;
    }

    @Override
    public boolean changesBeyondAnnotatedMethods() {
        return false;
    }

    @Override
    public String[] getAnnotatedMethodName() {
        return this.getTestMethodName();
    }

    @Override
    public Class<?>[][] getAnnotatedMethodParams() {
        return this.getTestMethodParams();
    }

    @Override
    public String getSourceDir() {
        return this.inputClassDir;
    }

    @Override
    public String getDestDir() {
        return this.copiedClassDir;
    }

    @Override
    public void transformClass() {
        String libname = this.getTestClass().toString().replaceFirst("class\\s", "");
        String className = libname.replaceAll("\\.", "/") + ".class";
        JavaToC j2c = new JavaToC();
        try //tranformation
        {
            j2c.startParsing(this.outputLibDir, libname);
            j2c.parseClass(this.getDestDir() + "/" + className);
            j2c.endParsing();
        } catch (IOException e) {
            Assertions.fail("Transformation failed");
            e.printStackTrace();
        }

        //building
        NativeCompiler compiler = new NativeCompiler();
        File[] sources = new File[]{new File(this.outputLibDir + File.separator + libname + ".c")};
        File destObj = new File(this.outputLibDir + File.separator + libname + SystemInfo.getObjectExtension());
        File destLib = new File(this.outputLibDir + File.separator + "lib" + libname + SystemInfo.getSharedLibraryExtension());
        String error;
        try {
            error = compiler.compileFile(sources, destObj);
            if (error == null) {
                error = compiler.compileSharedLib(new File[]{destObj}, destLib);
                if (error != null) {
                    Assertions.fail(error);
                }
            } else {
                Assertions.fail(error);
            }
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
    }

    /**
     * Code of transformed methods should look different between original and transformed classes
     */
    private void checkCodeInTransformedMethods() {
        //check for transformed code
        int length = getAnnotatedMethodName().length;
        for (int i = 0; i < length; i++) {
            int size1 = TestUtils.sizeofCode(sourceAnnotatedMethodNodes1[i]);
            int size2 = TestUtils.sizeofCode(destAnnotatedMethodNodes2[i]);
            String message = "method " + getAnnotatedMethodName()[i] + ", class " + getTestClass().getName() +
                    ": Original and transformed code have the same number of instructions";
            Assertions.assertNotEquals(size1, size2, message);
        }
    }


    /**
     * Annotations of transformed methods should look different between original and transformed classes
     */
    private void checkAnnotationsInTransformedMethods() {
        // check for changed annotations
        int length = getAnnotatedMethodName().length;
        for (int i = 0; i < length; i++) {
            int size1 = TestUtils.sizeofAnnotations(sourceAnnotatedMethodNodes1[i]);
            int size2 = TestUtils.sizeofAnnotations(destAnnotatedMethodNodes2[i]);
            String message = "method " + getAnnotatedMethodName()[i] + ", class " + getTestClass().getName() +
                    ": Original and transformed code have the same number of annotations";
            Assertions.assertNotEquals(size1, size2, message);
        }
    }


    /**
     * Code of methods that are not transformed should look the same between original and transformed classes
     */
    private void checkCodeInPreservedMethods() {
        int length2 = sourceNotAnnotatedMethodNodes3.length;
        for (int i = 0; i < length2; i++) {
            //<clinit> will be modified by this application
            if (sourceNotAnnotatedMethodNodes3[i].name.equals("<clinit>"))
                continue;
            int size1 = TestUtils.sizeofCode(sourceNotAnnotatedMethodNodes3[i]);
            int size2 = TestUtils.sizeofCode(destdNotAnnotatedMethodNodes4[i]);
            String message = "method " + sourceNotAnnotatedMethodNodes3[i].name + ", class " + getTestClass().getName() +
                    ": Non-trasformed method has the different number of instructions between original and transformed classes";
            Assertions.assertEquals(size1, size2, message);
        }
    }


    /**
     * Annotation of methods that are not transformed should look the same between original and transformed classes
     */
    private void checkAnnotationsInPreservedMethods() {
        // other methods should not change annotations
        int length2 = sourceNotAnnotatedMethodNodes3.length;
        for (int i = 0; i < length2; i++) {
            int size1 = TestUtils.sizeofAnnotations(sourceNotAnnotatedMethodNodes3[i]);
            int size2 = TestUtils.sizeofAnnotations(destdNotAnnotatedMethodNodes4[i]);
            String message = "method " + sourceNotAnnotatedMethodNodes3[i].name + ", class " + getTestClass().getName() +
                    ": Non-trasformed method has the different number of annotations between original and transformed classes";
            Assertions.assertEquals(size1, size2, message);
        }
    }


    /**
     * Get the parse trees of methods that should be changed by this transformation
     *
     * @param dir       Directory where to find the class
     * @param testClass Fully qualified name of the class
     * @return the methods that should be changed by this transformation
     * @throws FileNotFoundException
     * @throws IOException
     */
    protected MethodNode[] getMethodNodesForAnnotatedMethods(String dir, Class<?> testClass) throws FileNotFoundException, IOException {
        ClassReader cr = new ClassReader(new FileInputStream(TestUtils.fileFor(dir, testClass)));
        ClassNode cn = new ClassNode();
        cr.accept(cn, ClassReader.SKIP_DEBUG);

        int length = getAnnotatedMethodName().length;
        MethodNode[] result = new MethodNode[length];

        for (int i = 0; i < length; i++) {
            String expectedName = getAnnotatedMethodName()[i];
            for (MethodNode candidate : cn.methods) {
                if (expectedName.equals(candidate.name) && TestUtils.sameParameters(candidate.desc, getAnnotatedMethodParams()[i]))
                    result[i] = candidate;
            }
        }
        return result;
    }


    /**
     * Get the parse trees of the methods that should NOT be transformed
     *
     * @param dir       Directory where to find the class
     * @param clazz     Fully qualified class name
     * @param toExclude Methods that SHULD be transformed
     * @return Methods that should not be changed by the transformation
     * @throws FileNotFoundException
     * @throws IOException
     */
    protected MethodNode[] getOtherMethodNodes(String dir, Class<?> clazz, MethodNode[] toExclude) throws FileNotFoundException, IOException {
        ClassReader cr = new ClassReader(new FileInputStream(TestUtils.fileFor(dir, getTestClass())));
        ClassNode cn = new ClassNode();
        cr.accept(cn, ClassReader.SKIP_DEBUG);

        List<MethodNode> result = new ArrayList<>();
        for (MethodNode candidate : cn.methods) {
            if (TestUtils.notIn(candidate, toExclude))
                result.add(candidate);
        }
        return result.toArray(new MethodNode[0]);
    }


    /**
     * Assert that annotated fields have annotations removed in case the pattern matches
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void checkAnnotationInAnnotatedFields() throws FileNotFoundException, IOException {
        ClassReader cr = new ClassReader(new FileInputStream(TestUtils.fileFor(getDestDir(), getTestClass())));
        ClassNode cn = new ClassNode();
        cr.accept(cn, ClassReader.SKIP_DEBUG);
    }

    /**
     * Asserts that two object are the same, with a special clause that, in case of exceptions, checks just the exception
     * type
     *
     * @param expected Expected result
     * @param actual   Actual result
     * @param message  The output message in case of error
     */
    private void assertSameObj(Object expected, Object actual, String message) {
        if (expected instanceof Throwable && actual instanceof Throwable) {
            Assertions.assertEquals(expected.getClass(), actual.getClass(), message);
        } else
            Assertions.assertEquals(expected, actual, message);
    }
}
