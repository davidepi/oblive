package it.se.obfuscator.support;

import it.se.obfuscator.IllegalPatternException;

import java.util.ArrayList;

/**
 * Parses a signature in bytecode format and returns the various input types and the return type as JniType classes
 * An input example is the following (II)I
 *
 *  @author davidepi &lt;dpizzolotto@fbk.eu&gt;
 */
public class MethodSignature
{
    //array list containing the input types
    private final ArrayList<JniType> input;
    //the return type
    private final JniType returnType;

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

        //check if ( and ) are present in the method signature and there is a return type
        //then every other problem belongs to the JniType class
        int lastParenthesisIndex = bytecodeDesc.indexOf(')');
        if(bytecodeDesc.charAt(0)!='(' || lastParenthesisIndex<0 || lastParenthesisIndex+1==bytecodeDesc.length())
            throw new IllegalPatternException(bytecodeDesc + "is not a valid method signature");

        //parse the signature, input parameters
        //TODO: array support will change something inside here
        for(int i=1;i<lastParenthesisIndex;i++)
        {
            currentType.setLength(0);
            currentLetter = bytecodeDesc.charAt(i);
            currentType.append(currentLetter);
            if(currentLetter=='L') //object, need to parse everything until the ;
            {
                currentLetter = bytecodeDesc.charAt(++i);
                while (currentLetter != ';')
                {
                    currentType.append(currentLetter);
                    currentLetter = bytecodeDesc.charAt(++i);
                }
                currentType.append(currentLetter); //append also the ;
            }
            this.input.add(new JniType(currentType.toString()));
        }

        //parse return type
        this.returnType = new JniType(bytecodeDesc.substring(lastParenthesisIndex+1));
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
     * Returns the returnType parameter of this method
     * @return the returnType parameter of this method
     */
    public JniType getReturnType()
    {
        return returnType;
    }

    @Override
    public boolean equals(Object object)
    {
        if(object==null || (!MethodSignature.class.isAssignableFrom(object.getClass())))
            return false;
        else
        {
            final MethodSignature other = (MethodSignature) object;
            return this.input.equals(other.getInput()) && this.returnType.equals(other.getReturnType());
        }
    }
}
