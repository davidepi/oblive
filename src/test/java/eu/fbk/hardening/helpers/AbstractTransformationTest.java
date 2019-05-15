package eu.fbk.hardening.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract test class to transform a class and test the occurred transformation:
 * 1. The execution result has not changed
 * 2. The code has changed changed only for intended methods
 * 3. The annotation has changed only for the intended methods/fields
 *
 * @author mariano
 */

public abstract class AbstractTransformationTest {

    /**
     * The class to transform
     *
     * @return the class to transform
     */
    public abstract Class<?> getTestClass();

    /**
     * The field for which the annotation should be changed
     *
     * @param position Position of the field to query
     * @return
     */
    public abstract String getAnnotatedFieldName(int position);

    /**
     * The number of the annotated fields
     *
     * @return The number of the annotated fields
     */
    public abstract int getAnnotatedFieldSize();

    /**
     * A method that is meant to be run to test the transformation
     *
     * @param position Position of the method, in the list of method(s) to run
     * @return
     */
    public abstract String getTestMethodName(int position);

    /**
     * Number of methods to be run to test the transformation
     *
     * @return Number of methods
     */
    public abstract int getTestMethodSize();

    /**
     * The signature of the method to run to test the transformation, to uniquely identify it in case of overloading
     *
     * @param position Position of the method, in the list of methods to transform
     * @return the signature of the method
     */
    public abstract Class<?>[] getTestMethodParams(int position);

    /**
     * The actual parameters of the method to be transformed, to execute it
     *
     * @param position Position of the method, in the list of methods to transform
     * @return the parameters to call the method
     */
    public abstract Object[] getTestMethodArgs(int position);

    /**
     * A method that is meant to be changed by the transformation
     *
     * @param position Position of the method, in the list of methods to transform
     * @return
     */
    public abstract String getAnnotatedMethodName(int position);

    /**
     * Number of methods to be transformed in the class
     *
     * @return Number of methods
     */
    public abstract int getAnnotatedMethodSize();

    /**
     * The signature of the method to be transformed, to uniquely identify it in case of overloading
     *
     * @param position Position of the method, in the list of methods to transform
     * @return the signature of the method
     */
    public abstract Class<?>[] getAnnotatedMethodParams(int position);


    /**
     * Whether the changes of the transformation affects also code of methods with no annotation
     *
     * @return true in case changes also affect methods without annotations
     */
    public abstract boolean changesBeyondAnnotatedMethods();

    /**
     * Directory where to read the class file to transform
     *
     * @return the directory where the package structure starts
     */
    public abstract String getSourceDir();

    /**
     * Directory where to write the transformed class file
     *
     * @return the directory where the package structure starts
     */
    public abstract String getDestDir();

    /**
     * Calls the class transformation
     */
    public abstract void transformClass();


    //annotated methods
    private MethodNode[] sourceAnnotatedMethodNodes1;
    private MethodNode[] destAnnotatedMethodNodes2;

    //not-annotated methods
    private MethodNode[] sourceNotAnnotatedMethodNodes3;
    private MethodNode[] destdNotAnnotatedMethodNodes4;


    @Test
    public void test() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
        copyInput();
        transformClass();

        // run the original class
        Object[] result1 = runOriginalCode();

        // run the transformed class
        Object[] result2 = runTransformedCode();

        // check for same semantics
        for (int i = 0; i < getTestMethodSize(); i++) {
            String message = "method: " + getTestMethodName(i) + ", class: " + getTestClass().getName() + " --- Different execution result";
            assertSame(message, result1[i], result2[i]);
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

    }


    /**
     * Copy the original class into the destination before transforming it
     *
     * @throws IOException
     */

    protected void copyInput() throws IOException {
        File sourceFile = TestUtils.fileFor(getSourceDir(), getTestClass());
        File destFile = TestUtils.fileFor(getDestDir(), getTestClass());
        TestUtils.crateDirsFor(getDestDir(), getTestClass());
        Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }


    /**
     * Run the original code and accumulate results
     *
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */

    private Object[] runOriginalCode()
            throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // run original class
        int length = getTestMethodSize();
        Object object1 = getTestClass().newInstance();
        Method[] method1 = new Method[length];
        Object[] result1 = new Object[length];
        for (int i = 0; i < length; i++) {
            method1[i] = getTestClass().getMethod(getTestMethodName(i), getTestMethodParams(i));
            try {
                result1[i] = method1[i].invoke(object1, getTestMethodArgs(i));
            } catch (InvocationTargetException e) {
                result1[i] = e.getCause();
            }
        }
        return result1;
    }


    /**
     * Run the transformed code and accumulate results
     *
     * @return
     * @throws MalformedURLException
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */

    private Object[] runTransformedCode() throws MalformedURLException, ClassNotFoundException, IOException,
            InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int length = getTestMethodSize();
        URL transformed = new URL("file://" + (new File(getDestDir())).getAbsolutePath() + "/");
        URL[] urls = {transformed};
        // should be parent last class loader
        String[] localClasses = {getTestClass().getName()};
        TransformedClassLoader newLoader = new TransformedClassLoader(urls, getTestClass().getClassLoader(), localClasses);
        Class<?> testClass2 = newLoader.loadClass(getTestClass().getName());
        //System.out.println(testClass2.getClassLoader().getClass().getName());
        newLoader.close();

        Object object2 = testClass2.newInstance();
        Method[] method2 = new Method[length];
        Object[] result2 = new Object[length];
        for (int i = 0; i < length; i++) {
            method2[i] = testClass2.getMethod(getTestMethodName(i), getTestMethodParams(i));
            try {
                result2[i] = method2[i].invoke(object2, getTestMethodArgs(i));
            } catch (InvocationTargetException e) {
                result2[i] = e.getCause();
            }
        }
        return result2;
    }


    /**
     * Code of transformed methods should look different between original and transformed classes
     */

    private void checkCodeInTransformedMethods() {
        //check for transformed code
        int length = getAnnotatedMethodSize();
        for (int i = 0; i < length; i++) {
            int size1 = TestUtils.sizeofCode(sourceAnnotatedMethodNodes1[i]);
            int size2 = TestUtils.sizeofCode(destAnnotatedMethodNodes2[i]);
            String message = "method " + getAnnotatedMethodName(i) + ", class " + getTestClass().getName() +
                    ": Original and transformed code have the same number of instructions";
            Assertions.assertNotEquals(size1, size2, message);
//			System.err.println("Changed method ok");
        }
    }


    /**
     * Annotations of transformed methods should look different between original and transformed classes
     */

    private void checkAnnotationsInTransformedMethods() {
        // check for changed annotations
        int length = getAnnotatedMethodSize();
        for (int i = 0; i < length; i++) {
            int size1 = TestUtils.sizeofAnnotations(sourceAnnotatedMethodNodes1[i]);
            int size2 = TestUtils.sizeofAnnotations(destAnnotatedMethodNodes2[i]);
            String message = "method " + getAnnotatedMethodName(i) + ", class " + getTestClass().getName() +
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
//			System.err.println("Same annotations ok");
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

        int length = getAnnotatedMethodSize();
        MethodNode[] result = new MethodNode[length];

        for (int i = 0; i < length; i++) {
            String expectedName = getAnnotatedMethodName(i);
            for (MethodNode candidate : cn.methods) {
                if (expectedName.equals(candidate.name) && TestUtils.sameParameters(candidate.desc, getAnnotatedMethodParams(i)))
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

        List<MethodNode> result = new ArrayList<MethodNode>();
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

    private void assertSame(String message, Object result1, Object result2) {
        if (result1 instanceof Throwable && result2 instanceof Throwable) {
            Assertions.assertEquals(result1.getClass(), result2.getClass(), message);
        } else
            Assertions.assertEquals(result1, result2, message);
    }
}
