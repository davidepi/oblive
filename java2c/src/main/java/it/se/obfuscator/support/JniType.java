package it.se.obfuscator.support;

import it.se.obfuscator.IllegalPatternException;

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
 */
public class JniType
{
    //name of the jniName in c (jint, jboolean, etc...)
    private final String jniName;
    //if the jniName is an object this is the full name of the ojbect, including L and ; like Ljava/lang/String;
    private final String name;
    //true if the jniName is 64 bit long
    private final boolean doubleLength;
    //true if the jniName is a float or double
    private final boolean floatingPoint;

    /**
     *  Construct a new JniType by decoding the input string. The input string can be an object in the bytecode notation
     *  (i.e. Ljava/util/logging/Logger; ) or a letter representing the type (i.e. I for integer, Z for boolean).
     *  If the input is not correct an exception is thrown
     * @param bytecodeName The input in bytecode notation
     */
    public JniType(String bytecodeName)
    {
        switch(bytecodeName.charAt(0))
        {
            case 'I':
                this.jniName = "jint";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                break;
            case 'V':
                this.jniName = "void";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                break;
            case 'Z':
                this.jniName = "jboolean";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                break;
            case 'B':
                this.jniName = "jbyte";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                break;
            case 'C':
                this.jniName = "jchar";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                break;
            case 'S':
                this.jniName = "jshort";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = false;
                break;
            case 'J':
                this.jniName = "jlong";
                this.name = this.jniName;
                this.doubleLength = true;
                this.floatingPoint = false;
                break;
            case 'F':
                this.jniName = "jfloat";
                this.name = this.jniName;
                this.doubleLength = false;
                this.floatingPoint = true;
                break;
            case 'D':
                this.jniName = "jdouble";
                this.name = this.jniName;
                this.doubleLength = true;
                this.floatingPoint = true;
                break;
            case 'L':
                if(bytecodeName.charAt(bytecodeName.length()-1)!=';') //not in the canonical form
                    throw new IllegalPatternException("Unknown bytecode type " + bytecodeName);
                this.jniName = "jobject";
                this.name = bytecodeName.substring(1, bytecodeName.length() - 1);
                this.doubleLength = false;
                this.floatingPoint = false;
                break;
            //TODO: array support
            default:
                throw new IllegalPatternException("Unknown bytecode type "+ bytecodeName);
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
}
