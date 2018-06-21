package eu.fbk.hardening.support;

import eu.fbk.hardening.IllegalPatternException;

/**
 * Class used to parse string representing types in the bytecode notation and extract features.
 * Bytecode notation consists of the following values:
 *  I - integer
 *  V - void
 *  Z - boolean
 *  B - byte
 *  C - char
 *  S - short
 *  J - long
 *  F - float
 *  D - double
 *  Lpackage/name; - object
 *
 *  @author davidepi &lt;dpizzolotto@fbk.eu&gt;
 */
public class JniType
{
    //name of the jniName in c (jint, jboolean, etc...)
    private String jniName;
    //letter used in the jvalue union
    private char jvalueLetter;
    //if the jniName is an object this is the full name of the ojbect, including L and ; like Ljava/lang/String;
    //or the primitive type if primitive arrays (which are treated as jobject in the jni, so the jniName is jobject)
    private final String name;
    //true if the jniName is 64 bit long
    private final boolean doubleLength;
    //true if the jniName is a float or double
    private final boolean floatingPoint;
    //multidimensional array
    private int arrayDepth;

    /**
     *  Construct a new JniType by decoding the input string. The input string can be an object in the bytecode notation
     *  (i.e. Ljava/util/logging/Logger; ) or a letter representing the type (i.e. I for integer, Z for boolean).
     *  If the input is not correct an exception is thrown
     * @param bytecodeName The input in bytecode notation
     */
    public JniType(String bytecodeName)
    {
        arrayDepth = 0;
        for(int i=0;i<bytecodeName.length()-1;i++) //-1 ensures to leave at least one character for the switch
            if(bytecodeName.charAt(i)=='[')
                arrayDepth++;
        switch(bytecodeName.charAt(arrayDepth))
        {
            case 'I':
                this.jniName = "jint";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                this.jvalueLetter = 'i';
                break;
            case 'V':
                this.jniName = "void";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                this.jvalueLetter = '\0';
                break;
            case 'Z':
                this.jniName = "jboolean";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                this.jvalueLetter = 'z';
                break;
            case 'B':
                this.jniName = "jbyte";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                this.jvalueLetter = 'b';
                break;
            case 'C':
                this.jniName = "jchar";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                this.jvalueLetter = 'c';
                break;
            case 'S':
                this.jniName = "jshort";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                this.jvalueLetter = 's';
                break;
            case 'J':
                this.jniName = "jlong";
                this.name = this.jniName;
                this.doubleLength = true;
                this.floatingPoint = false;
                this.jvalueLetter = 'j';
                break;
            case 'F':
                this.jniName = "jfloat";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = true;
                this.jvalueLetter = 'f';
                break;
            case 'D':
                this.jniName = "jdouble";
                this.name = this.jniName;
                this.doubleLength = true;
                this.floatingPoint = true;
                this.jvalueLetter = 'd';
                break;
            case 'L':
                if(bytecodeName.charAt(bytecodeName.length()-1)!=';') //not in the canonical form
                    throw new IllegalPatternException("Unknown bytecode type " + bytecodeName);
                this.jniName = "jobject";
                this.name = bytecodeName.substring(arrayDepth+1, bytecodeName.length() - 1);
                this.doubleLength = false;
                this.floatingPoint = false;
                this.jvalueLetter = 'l';
                if(this.name.length()==0)
                    throw new IllegalPatternException("Empty object name");
                break;
            default:
                throw new IllegalPatternException("Unknown bytecode type "+ bytecodeName);
        }
        if(arrayDepth>0)
        {
            this.jniName = "jobject";
            this.jvalueLetter = 'l';
        }
    }

    /**
     * Returns the name of the object.
     * If the type is not an object this method has the same behaviour of getJniName()
     * @return the name of the object in bytecode notation, without the characters [ L or ;
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the jni name of this type, for example jint
     * @return The jni name of this type
     */
    public String getJniName()
    {
        return jniName;
    }

    /**
     * Returns the letter used in the jvalue jni union to represent this type
     * @return The jvalue letter for this type
     */
    public char getJvalueLetter()
    {
        return jvalueLetter;
    }

    /**
     * Returns true if the type requires 64 bit
     * @return true if the type is a long or a double, false otherwise
     */
    public boolean isDoubleLength()
    {
        return doubleLength;
    }

    /**
     * Returns true if the type is a value expressed with an IEEE 754 number
     * @return true if the type is a float or a double, false otherwise
     */
    public boolean isFloatingPoint()
    {
        return floatingPoint;
    }


    /**
     * Returns the number of dimensions of an array. The output will be 0 if the type is not an array.
     * @return the number of dimensions of an array. ie. for int[][] aka [[I will return 2
     */
    public int getArrayDepth()
    {
        return arrayDepth;
    }

    @Override
    public boolean equals(Object object)
    {
        if(object==null || (!JniType.class.isAssignableFrom(object.getClass())))
            return false;
        else
        {
            final JniType other = (JniType)object;
            return this.name.equals(other.getName());
        }
    }
}
