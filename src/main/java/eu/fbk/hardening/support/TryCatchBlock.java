package eu.fbk.hardening.support;

/**
 * Class containing data useful to define a try-catch block
 *
 * @author D.Pizzolotto
 */
public class TryCatchBlock {
    /**
     * Name of the label where the try-catch block starts
     */
    public String start;

    /**
     * Index of the labels array containing the label where the try-catch block starts
     */
    int startIndex;

    /**
     * Name of the label where the try-catch block ends
     */
    public String end;

    /**
     * Index of the labels array containing the label where the try-catch block ends
     */
    int endIndex;

    /**
     * Java name (such as Ljava/lang/object; of the type caught by this try-catch block
     */
    public String catched;

    /**
     * Length of the try-catch block
     */
    public int length;

    /**
     * Name of the label where the try-catch handling is performed
     */
    public String handle;

    /**
     * Order in which the try-catch has been encountered
     */
    public int order;
}
