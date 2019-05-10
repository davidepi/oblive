package eu.fbk.hardening.support;

/**
 * Class used to wrap together several parameters describing a method being visited.
 *
 * @author D.Pizzolotto
 */
public class ClassMethodPair {
    //name of the class containing the method
    private String className;
    //name of the method
    private String methodName;
    //signature of the method -> in java style (a string)
    private String desc;
    //signature of the method -> java style parsed using the MethodSignature class
    private MethodSignature signature;
    //true if the method has an overloaded method THAT SHOULD BE OBFUSCATED AS WELL!!!!
    public boolean overloaded;

    /**
     * Initialize the ClassMethodPair class
     *
     * @param sclass     The name of the class being parsed
     * @param smethod    The name of the method being parsed
     * @param ssignature The signature of the method being parsed as a Java string, i.e (ILjava/lang/String;)V
     */
    public ClassMethodPair(String sclass, String smethod, String ssignature) {
        this.className = sclass;
        this.methodName = smethod;
        this.desc = ssignature;
        this.signature = new MethodSignature(ssignature);
        //cannot set this variable until every method has been processed
        overloaded = false;
    }

    /**
     * Getter: returns the class name param
     *
     * @return The name of the class of this ClassMethodPair
     */
    public String getClassName() {
        return className;
    }

    /**
     * Setter: sets the class name param
     *
     * @param name The name of the class of this ClassMethodPair
     */
    public void setClassName(String name) {
        this.className = name;
    }

    /**
     * Getter: returns the method name param
     *
     * @return The name of the method symbolized by this ClassMethodPair
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Getter: returns the java signature of this method
     *
     * @return A MethodSignature object containing the parsed version of this method signature
     */
    public MethodSignature getSignature() {
        return signature;
    }

    /**
     * Setter: sets the signature of this method
     *
     * @param sign A string representing the Java Bytecode signature of the method symbolized by this
     *             ClassMethodPair
     */
    public void setSignature(String sign) {
        this.desc = sign;
        this.signature = new MethodSignature(sign);
    }

    /**
     * Getter: returns the desc of this method
     *
     * @return A string representing the Java Bytecode signature of the method symbolized by this ClassMethodPair
     */
    public String getDesc() {
        return desc;
    }

}
