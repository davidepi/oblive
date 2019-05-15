package eu.fbk.hardening.helpers;

/**
 * Interface providing various information about a Test. This interface is used where several tests shares the same
 * structure, but requires different parameters. In this case, all the correctness tests are essentially the same
 * but requires different parameters. In this way only the necessary information are provided without duplicating code.
 *
 * The method provided by this class must return the information about the TESTED class.
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
     * @param position Position of the field to query
     * @return
     */
    String getAnnotatedFieldName(int position);

    /**
     * The number of the annotated fields
     *
     * @return The number of the annotated fields
     */
    int getAnnotatedFieldSize();

    /**
     * A method that is meant to be run to test the transformation
     *
     * @return
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
     * @return the parameters to call the method
     */
    Object[][] getTestMethodArgs();

    /**
     * A method that is meant to be changed by the transformation
     *
     * @return
     */
    String[] getAnnotatedMethodName();

    /**
     * The signature of the method to be transformed, to uniquely identify it in case of overloading
     *
     * @return the signature of the method
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

    /**
     * Calls the class transformation
     */
    void transformClass();
}
