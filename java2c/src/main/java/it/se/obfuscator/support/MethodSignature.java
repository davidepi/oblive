package it.se.obfuscator.support;

import it.se.obfuscator.IllegalPatternException;

import java.util.ArrayList;

/**
 * Parses a signature in bytecode format and returns the various input types and the return type as JniType classes
 * An input example is the following (II)I
 */
public class MethodSignature
{
    //array list containing the input types
    private final ArrayList<JniType> input;
    //the return type
    private final JniType output;

    /**
     * Constructs a MethodSignature after giving a signature in bytecode notation. The signature is expected as
     * two parenthesis enclosing the input type and the return type. No spaces or commas. The various types can
     * be found in the description of the JniType class.
     * @param bytecodeDesc A string representing the signature of the method. For example (Ljava/lang/String;I)V
     */
    public MethodSignature(String bytecodeDesc)
    {
        this.input = new ArrayList<>();
        StringBuilder currentType = new StringBuilder();
        char currentLetter;

        //check if ( and ) are present in the method signature
        int lastParenthesisIndex = bytecodeDesc.indexOf(')');
        if(bytecodeDesc.charAt(0)!='(' || lastParenthesisIndex<0)
            throw new IllegalPatternException(bytecodeDesc + "is not a valid method signature");

        //parse the signature, input parameters
        //TODO: array support will change something inside here
        for(int i=0;i<lastParenthesisIndex;i++)
        {
            currentLetter = bytecodeDesc.charAt(i);
            currentType.append(currentLetter);
            if(currentLetter=='L') //object, need to parse everything until the ;
            {
                while (currentLetter != ';')
                {
                    currentType.append(currentLetter);
                    currentLetter = bytecodeDesc.charAt(++i);
                }
                currentType.append(currentLetter);
            }
            this.input.add(new JniType(currentType.toString()));
        }

        //parse return type
        this.output = new JniType(bytecodeDesc.substring(lastParenthesisIndex+1));
    }

    /**
     * Returns the input parameters of this method
     * @return the input parameters of this method
     */
    public ArrayList<JniType> getInput()
    {
        return input;
    }

    /**
     * Returns the output parameter of this method
     * @return the output parameter of this method
     */
    public JniType getOutput()
    {
        return output;
    }
}
