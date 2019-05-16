package eu.fbk.hardening.helpers;

/**
 * Interface providing various information about a Test.
 * This can work as a skeleton for testing an obfuscation tool.
 * More specifically, the kind of tests expected are tests which require a sort of transformation (in this case the
 * obfuscation) before being run. This interface provides method returning the name of the annotated (obfuscated) method,
 * the name of the tested method, etc...
 * In this way every test can just extend a skeleton implementing this class and override just the required functions
 * functions.
 *
 * @author M.Ceccato && D.Pizzolotto
 */
public interface TestInterface {

    /**
     * The class to transform
     *
     * @return the class to transform
     */
    Class<?> getTestClass();

    /**
     * The field for which the annotation should be changed
     *
     * @return the annotated field
     */
    String[] getAnnotatedFieldName();

    /**
     * A method that is meant to be run to test the transformation
     *
     * @return the name of the method
     */
    String[] getTestMethodName();

    /**
     * The signature of the method to run to test the transformation, to uniquely identify it in case of overloading
     *
     * @return the signature of the method
     */
    Class<?>[][] getTestMethodParams();

    /**
     * The actual parameters of the method to be transformed, to execute it
     *
     * @return the parameters used when calling the method
     */
    Object[][] getTestMethodArgs();

    /**
     * The methods that are meant to be changed by the transformation
     *
     * @return the annotated methods
     */
    String[] getAnnotatedMethodName();

    /**
     * The signatures of the methods to be transformed, to uniquely identify them in case of overloading
     *
     * @return the signature of the methods
     */
    Class<?>[][] getAnnotatedMethodParams();

    /**
     * Whether the changes of the transformation affects also code of methods with no annotation
     *
     * @return true in case changes also affect methods without annotations
     */
    boolean changesBeyondAnnotatedMethods();

    /**
     * Directory where to read the class file to transform
     *
     * @return the directory where the package structure starts
     */
    String getSourceDir();

    /**
     * Directory where to write the transformed class file
     *
     * @return the directory where the package structure starts
     */
    String getDestDir();
}
