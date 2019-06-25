package eu.fbk.hardening.helpers;

import eu.fbk.hardening.support.JniType;
import eu.fbk.hardening.support.NativeCompiler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
public abstract class AbstractTestCorrectnessTemplate extends Java2CTests {

    //annotated methods
    private MethodNode[] sourceAnnotatedMethodNodes1;
    private MethodNode[] destAnnotatedMethodNodes2;

    //not-annotated methods
    private MethodNode[] sourceNotAnnotatedMethodNodes3;
    private MethodNode[] destdNotAnnotatedMethodNodes4;

    /**
     * Checks the correctness of the transformation
     */
    @Test
    public void testCorrectness() {
        try {

            //Assert parameters length: name, signature and parameters should be of the same length for annotated and for test
            Assertions.assertEquals(getTestMethodParams().length, getTestMethodName().length, "Param array length does not match Name array length for tested methods");
            Assertions.assertEquals(getTestMethodArgs().length, getTestMethodName().length, "Args array length does not match Name array length for tested methods");
            Assertions.assertEquals(getAnnotatedMethodParams().length, getAnnotatedMethodName().length, "Param array length does not match Name array length for annotated methods");

            TestUtils.copyInput(getSourceDir(), getDestDir(), getTestClass());
            String libname = this.getTestClass().toString().replaceFirst("class\\s", "");
            String className = libname.replaceAll("\\.", "/") + ".class";
            transformJava2C(className, libname, getDestDir());
            NativeCompiler compiler = new NativeCompiler();
            buildJava2C(libname, compiler);

            Class clazzOriginal = TestUtils.loadClass(null, getTestClass().getCanonicalName());
            Class clazzTransformed = TestUtils.loadClass(getDestDir(), getTestClass().getCanonicalName());

            Object instanceOriginal = clazzOriginal.newInstance();
            Object instanceTransformed = clazzTransformed.newInstance();

            // run the original class
            Object[] result1 = TestUtils.runCode(instanceOriginal, getTestMethodName(), getTestMethodParams(), getTestMethodArgs());

            // run the transformed class
            Object[] result2 = TestUtils.runCode(instanceTransformed, getTestMethodName(), getTestMethodParams(), getTestMethodArgs());

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
            //<clinit> will be modified by Java2C
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
     * @throws IOException if the .class cannot be found on disk
     */
    protected MethodNode[] getMethodNodesForAnnotatedMethods(String dir, Class<?> testClass) throws IOException {
        ClassReader cr = new ClassReader(new FileInputStream(TestUtils.fileFor(dir, testClass)));
        ClassNode cn = new ClassNode();
        cr.accept(cn, ClassReader.SKIP_DEBUG);

        int length = getAnnotatedMethodName().length;
        MethodNode[] result = new MethodNode[length];
        StringBuilder expectedParametersSb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            String expectedName = getAnnotatedMethodName()[i];
            expectedParametersSb.setLength(0);
            Class<?>[] expectedParamsClass = getAnnotatedMethodParams()[i];
            for (Class<?> param : expectedParamsClass) {
                expectedParametersSb.append(new JniType(param).getInternalRepresentation());
            }
            String expectedParameters = expectedParametersSb.toString();
            for (MethodNode candidate : cn.methods) {
                String candidateParameters = candidate.desc.substring(1, candidate.desc.lastIndexOf(')'));
                if (expectedName.equals(candidate.name) && expectedParameters.equals(candidateParameters))
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
     * @throws IOException if the .class file cannot be found on disk
     */
    protected MethodNode[] getOtherMethodNodes(String dir, Class<?> clazz, MethodNode[] toExclude) throws IOException {
        ClassReader cr = new ClassReader(new FileInputStream(TestUtils.fileFor(dir, clazz)));
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
     * @throws IOException if the .class file cannot be found on disk
     */
    private void checkAnnotationInAnnotatedFields() throws IOException {
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
