package eu.fbk.hardening.helpers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * Utility class for testing purposes
 *
 * @author M.Ceccato
 * @author D.Pizzolotto
 */

public class TestUtils {


    /**
     * Compute the relative file name for a class
     *
     * @param clazz the class to look for
     * @return The relative file name representing this class, for parsing purposes
     */

    public static String fileNameOf(Class<?> clazz) {
        return (clazz.getName().replace('.', '/')) + ".class";
    }

    /**
     * Compute the file handler for a class in a given directory
     *
     * @param dir   where the package structure starts
     * @param clazz the class to look for
     * @return The File representing this class, for parsing purposes
     */

    public static File fileFor(String dir, Class<?> clazz) {
        return new File(dir + "/" + clazz.getName().replace('.', '/') + ".class");
    }

    /**
     * Compute the file name for a class in a given directory
     *
     * @param dir   where the package structure starts
     * @param clazz the class to look for
     * @return The String representing this class, for parsing purposes
     */

    public static String fileNameFor(String dir, Class<?> clazz) {
        return dir + "/" + (clazz.getName().replace('.', '/')) + ".class";
    }

    /**
     * Create the directory to store the transformed class
     *
     * @param dir   where the package structure will be starting
     * @param clazz the class to store there (useful for the package name)
     */

    public static void createDirsFor(String dir, Class<?> clazz) {
        String newDirName = dir + "/" + (clazz.getPackage().getName().replace('.', '/'));
        File newDir = new File(newDirName);
        newDir.mkdirs();
    }

    /**
     * Check it a method is in the list
     *
     * @param candidate Method to check
     * @param toExclude Exclusion list
     * @return whether the first parameter is in the list (second parameter)
     */

    public static boolean notIn(MethodNode candidate, MethodNode[] toExclude) {
        for (MethodNode exclusion : toExclude)
            if (candidate.name.equals(exclusion.name) && candidate.desc.equals(exclusion.desc))
                return false;
        return true;
    }


    /**
     * Checks if the parsed method signature correspond to the specified method signature
     *
     * @param parsedDescriptor the method formal parameters from the parsed class
     * @param expected         the method formal parameters from the pattern
     * @return true if the two signature match, false otherwise
     */

    public static boolean sameParameters(String parsedDescriptor, Class<?>[] expected) {
        if (parsedDescriptor == null) {
            return expected.length == 0;
        }
        Type[] actual = Type.getArgumentTypes(parsedDescriptor);
        if (actual.length != expected.length) {
            return false;
        }
        for (int i = 0; i < actual.length; i++) {
            if (!actual[i].getClassName().equals(expected[i].getName())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Extracts the number of annotations in the given method
     *
     * @param node parse tree of method
     * @return the number of annotations in the method
     */

    public static int sizeofAnnotations(MethodNode node) {
        List<AnnotationNode> annotations = node.invisibleAnnotations;
        if (annotations == null)
            return 0;
        else
            return annotations.size();
    }


    /**
     * Extracts the number of bytecode statements in the given method
     *
     * @param node parse tree of method
     * @return the number of bytecode statements in the method
     */

    public static int sizeofCode(MethodNode node) {
        InsnList code = node.instructions;
        if (code == null) return 0;
        else
            return node.instructions.size();
    }

    /**
     * Copy the original class into the destination
     *
     * @param source The path to the start of the package dir of the source class
     * @param dest   The path to the start of the package dir of the destination class
     * @throws IOException
     */
    public static void copyInput(String source, String dest, Class<?> testClass) throws IOException {
        File sourceFile = TestUtils.fileFor(source, testClass);
        File destFile = TestUtils.fileFor(dest, testClass);
        TestUtils.createDirsFor(dest, testClass);
        Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * This method is used to run a specific method of another class via reflection and then collect its results. It
     * can load any kind of class also outside the classpath.
     *
     * @param dir       The string where the class package directory starts. If the class is in the classpath it can be null
     * @param testClass the class that will be tested
     * @param testName  An array of method names, these are the methods that will be run
     * @param testParam An array of parameters (like int.class) required by the methods that will be run
     * @param testArgs  The actual value of the parameters that will be used when running the methods
     * @return An array containing the results of the various methods run
     * @throws ClassNotFoundException if the testClass can not be found in the .class file
     * @throws IOException            if the .class file does not exists on disk
     * @throws IllegalAccessException if the testName, testParam and testArgs arguments have different length
     * @throws NoSuchMethodException  if the provided method does not exist in the class
     * @throws InstantiationException if the class can not be instantiated
     */
    public static Object[] runCode(@Nullable String dir, Class<?> testClass,
                                   @NotNull String[] testName, @NotNull Class<?>[][] testParam, Object[][] testArgs)
            throws ClassNotFoundException, IOException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        if (testName.length != testParam.length || testName.length != testArgs.length)
            throw new IllegalAccessException("Mismatched number of operators between: " +
                    "methods to tests (" + testName.length + "), " +
                    "parameters for these methods (" + testParam.length + "), " +
                    "arguments for these methods (" + testArgs.length + ")");
        Class<?> loadedClass;
        int length = testName.length;
        if (dir != null) {
            URL transformed = new URL("file://" + (new File(dir)).getAbsolutePath() + "/");
            URL[] urls = {transformed};
            // should be parent last class loader
            String[] localClasses = {testClass.getName()};
            TransformedClassLoader newLoader = new TransformedClassLoader(urls, testClass.getClassLoader(), localClasses);
            Class<?> testClassDifferentLoader = newLoader.loadClass(testClass.getName());
            newLoader.close();
            loadedClass = testClassDifferentLoader;
        } else {
            loadedClass = testClass;
        }
        Object runClass = loadedClass.newInstance();
        Method[] runMethod = new Method[length];
        Object[] runValues = new Object[length];


        for (int i = 0; i < length; i++) {
            runMethod[i] = loadedClass.getMethod(testName[i], testParam[i]);
            try {
                runValues[i] = runMethod[i].invoke(runClass, testArgs[i]);
            } catch (InvocationTargetException e) {
                runValues[i] = e.getCause();
            }
        }
        return runValues;
    }

}
