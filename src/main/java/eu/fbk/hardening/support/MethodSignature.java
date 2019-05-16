package eu.fbk.hardening.support;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Parses a signature in bytecode format and returns the various input types and the return type as JniType classes
 * An input example is the following (II)I
 *
 * @author D.Pizzolotto
 */
public class MethodSignature {
    //array list containing the input types
    private final ArrayList<JniType> input;
    //the return type
    private final JniType returnType;

    /**
     * Constructs a MethodSignature after giving a signature in bytecode notation. The signature is expected as
     * two parenthesis enclosing the input type and the return type. No spaces or commas. The various types can
     * be found in the description of the JniType class.
     *
     * @param bytecodeDesc A string representing the signature of the method. For example (Ljava/lang/String;I)V
     */
    public MethodSignature(@NotNull String bytecodeDesc) {
        this.input = new ArrayList<>();
        boolean parsingObj = false;
        StringBuilder currentType = new StringBuilder();
        char currentLetter;

        //check if ( and ) are present in the method signature and there is a return type
        //then every other problem belongs to the JniType class
        int lastParenthesisIndex = bytecodeDesc.indexOf(')');
        if (bytecodeDesc.charAt(0) != '(' || lastParenthesisIndex < 0
                || lastParenthesisIndex + 1 == bytecodeDesc.length()) {
            throw new IllegalPatternError(bytecodeDesc + "is not a valid method signature");
        }

        //parse the signature, input parameters
        for (int i = 1; i < lastParenthesisIndex; i++) {
            currentLetter = bytecodeDesc.charAt(i);
            currentType.append(currentLetter);
            if (currentLetter == ';' && parsingObj) {
                parsingObj = false;
            }
            if (currentLetter == '[' || parsingObj) {
                continue;
            }
            if (currentLetter == 'L') { //object, need to parse everything until the ;
                parsingObj = true;
                continue;
            }
            this.input.add(new JniType(currentType.toString()));
            currentType.setLength(0);
        }
        if (currentType.length() != 0) { //add strings in the form of ([[[) so the JniType class can throw an error
            this.input.add(new JniType(currentType.toString()));
        }

        //parse return type
        this.returnType = new JniType(bytecodeDesc.substring(lastParenthesisIndex + 1));
    }

    /**
     * Returns the input parameters of this method
     *
     * @return the input parameters of this method
     */
    public ArrayList<JniType> getInput() {
        return input;
    }

    /**
     * Returns the returnType parameter of this method
     *
     * @return the returnType parameter of this method
     */
    public JniType getReturnType() {
        return returnType;
    }

    /**
     * Checks if his objects is identical to another one
     *
     * @param o The object used for the comparison
     * @return true if the two objects are equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodSignature that = (MethodSignature) o;
        return getInput().equals(that.getInput()) &&
                getReturnType().equals(that.getReturnType());
    }

    /**
     * Generates an hash code for this object. Note that a same hash code is necessary to assert object equality but
     * does not guarantee it
     *
     * @return An hash code for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getInput(), getReturnType());
    }

}
