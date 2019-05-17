package eu.fbk.hardening.helpers;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodNode;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
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
    @NotNull
    public static String fileNameOf(@NotNull Class<?> clazz) {
        return (clazz.getName().replace('.', '/')) + ".class";
    }

    /**
     * Compute the file handler for a class in a given directory
     *
     * @param dir   where the package structure starts
     * @param clazz the class to look for
     * @return The File representing this class, for parsing purposes
     */
    @NotNull
    @Contract("_, _ -> new")
    public static File fileFor(String dir, @NotNull Class<?> clazz) {
        return new File(dir + "/" + clazz.getName().replace('.', '/') + ".class");
    }

    /**
     * Compute the file name for a class in a given directory
     *
     * @param dir   where the package structure starts
     * @param clazz the class to look for
     * @return The String representing this class, for parsing purposes
     */
    @NotNull
    public static String fileNameFor(String dir, @NotNull Class<?> clazz) {
        return dir + "/" + (clazz.getName().replace('.', '/')) + ".class";
    }

    /**
     * Create the directory to store the transformed class
     *
     * @param dir   where the package structure will be starting
     * @param clazz the class to store there (useful for the package name)
     */
    public static void createDirsFor(String dir, @NotNull Class<?> clazz) {
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
    public static boolean notIn(MethodNode candidate, @NotNull MethodNode[] toExclude) {
        for (MethodNode exclusion : toExclude)
            if (candidate.name.equals(exclusion.name) && candidate.desc.equals(exclusion.desc))
                return false;
        return true;
    }

    /**
     * Extracts the number of annotations in the given method
     *
     * @param node parse tree of method
     * @return the number of annotations in the method
     */
    public static int sizeofAnnotations(@NotNull MethodNode node) {
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
    public static int sizeofCode(@NotNull MethodNode node) {
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
     * @throws IOException if the path does not exists
     */
    public static void copyInput(String source, String dest, Class<?> testClass) throws IOException {
        File sourceFile = TestUtils.fileFor(source, testClass);
        File destFile = TestUtils.fileFor(dest, testClass);
        TestUtils.createDirsFor(dest, testClass);
        Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * This method is used to load any kind of class from any source file. If dir is null, the original classloader
     * will be used, equivalent of calling Class.forName(), otherwise the URLClassLoader will be used
     *
     * @param dir                The directory where the package structure of the class starts
     * @param classCanonicalName canonical name of the class, in the form java.lang.String
     * @return A Class object representing the class
     */
    public static Class<?> loadClass(@Nullable String dir, @NotNull String classCanonicalName) throws IOException, ClassNotFoundException {
        Class<?> loadedClass;
        if (dir != null) {
            URL transformed = new URL("file://" + (new File(dir)).getAbsolutePath() + "/");
            URL[] urls = {transformed};
            loadedClass = new URLClassLoader(urls).loadClass(classCanonicalName);
        } else {
            loadedClass = Class.forName(classCanonicalName);
        }
        return loadedClass;
    }

    /**
     * This method is used to run a specific method of another class via reflection and then collect its results.
     *
     * @param caller    The object invoking the method
     * @param testName  An array of method names, these are the methods that will be run
     * @param testParam An array of parameters (like int.class) required by the methods that will be run
     * @param testArgs  The actual value of the parameters that will be used when running the methods
     * @return An array containing the results of the various methods run
     * @throws IllegalAccessException if the testName, testParam and testArgs arguments have different length
     * @throws NoSuchMethodException  if the provided method does not exist in the class
     */
    public static Object[] runCode(Object caller, @NotNull String[] testName, @NotNull Class<?>[][] testParam, Object[][] testArgs)
            throws IllegalAccessException, NoSuchMethodException {
        if (testName.length != testParam.length || testName.length != testArgs.length)
            throw new IllegalAccessException("Mismatched number of operators between: " +
                    "methods to tests (" + testName.length + "), " +
                    "parameters for these methods (" + testParam.length + "), " +
                    "arguments for these methods (" + testArgs.length + ")");

        int length = testName.length;
        Method[] runMethod = new Method[length];
        Object[] runValues = new Object[length];
        for (int i = 0; i < length; i++) {
            runMethod[i] = caller.getClass().getMethod(testName[i], testParam[i]);
            try {
                runValues[i] = runMethod[i].invoke(caller, testArgs[i]);
            } catch (InvocationTargetException e) {
                runValues[i] = e.getCause();
            }
        }
        return runValues;
    }

}
