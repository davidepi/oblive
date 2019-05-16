package eu.fbk.hardening.support;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Class used to parse string representing types in the bytecode notation and extract features.
 * Bytecode notation consists of the following values:
 * I - integer
 * V - void
 * Z - boolean
 * B - byte
 * C - char
 * S - short
 * J - long
 * F - float
 * D - double
 * Lpackage/name; - object
 *
 * @author D.Pizzolotto
 */
public class JniType {
    //if the jniName is an object this is the full name of the ojbect, excluding L and ; like java/lang/String
    //or the primitive type if primitive arrays (which are treated as jobject in the jni, so the jniName is jobject)
    private String name;
    //true if the jniName is 64 bit long
    private boolean doubleLength;
    //true if the jniName is a float or double
    private boolean floatingPoint;
    //name of the jniName in c (jint, jboolean, etc...)
    private String jniName;
    //letter used in the jvalue union
    private char jvalueLetter;
    //letter identifying the primitive type. Always identical to jvalue letter except for primitive arrays
    private char primitiveLetter;
    //multidimensional array
    private int arrayDepth;


    /**
     * Construct a new JniType by decoding the input string. The input string can be an object in the bytecode notation
     * (i.e. Ljava/util/logging/Logger; ) or a letter representing the type (i.e. I for integer, Z for boolean).
     * If the input is not correct an exception is thrown
     *
     * @param bytecodeName The input in bytecode notation
     */
    public JniType(@NotNull String bytecodeName) {
        init(bytecodeName);
    }

    /**
     * Construct a new JniType by using a Class object.
     * This is equivalent of calling JniType(param.getName())
     *
     * @param param A parameter described as a Class object
     */
    public JniType(@NotNull Class<?> param) {
        if (!param.isArray()) {
            if (param.isPrimitive()) {
                switch (param.getName()) {
                    case "void":
                        init("V");
                        break;
                    case "boolean":
                        init("Z");
                        break;
                    case "byte":
                        init("B");
                        break;
                    case "char":
                        init("C");
                        break;
                    case "short":
                        init("S");
                        break;
                    case "long":
                        init("J");
                        break;
                    case "float":
                        init("F");
                        break;
                    case "double":
                        init("D");
                        break;
                    default:
                        init("I");
                        break;
                }
            } else {
                init("L" + param.getName().replaceAll("\\.", "/") + ";");
            }
        } else {
            init(param.getName().replaceAll("\\.", "/"));
        }
    }

    /**
     * Performs the actual initialization.
     *
     * @param bytecodeName The string in bytecode notation
     */
    private void init(@NotNull String bytecodeName) {
        arrayDepth = 0;
        for (int i = 0; i < bytecodeName.length() - 1; i++) { //-1 ensures at least one character for the switch
            if (bytecodeName.charAt(i) == '[') {
                arrayDepth++;
            }
        }
        switch (bytecodeName.charAt(arrayDepth)) {
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
                if (bytecodeName.charAt(bytecodeName.length() - 1) != ';') { //not in the canonical form
                    throw new IllegalPatternError("Unknown bytecode type " + bytecodeName);
                }
                this.jniName = "jobject";
                this.name = bytecodeName.substring(arrayDepth + 1, bytecodeName.length() - 1);
                this.doubleLength = false;
                this.floatingPoint = false;
                this.jvalueLetter = 'l';
                if (this.name.length() == 0) {
                    throw new IllegalPatternError("Empty object name");
                }
                break;
            default:
                throw new IllegalPatternError("Unknown bytecode type " + bytecodeName);
        }
        primitiveLetter = jvalueLetter;
        if (arrayDepth > 0) {
            this.jniName = "jobject";
            this.jvalueLetter = 'l';
        }
    }

    /**
     * Returns the name of the object.
     * If the type is not an object this method has the same behaviour of getJniName()
     *
     * @return the name of the object in bytecode notation, without the characters [ L or ;
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the jni name of this type, for example jint
     *
     * @return The jni name of this type
     */
    public String getJniName() {
        return jniName;
    }

    /**
     * Returns the letter used in the jvalue jni union to represent this type
     *
     * @return The jvalue letter for this type
     */
    public char getJvalueLetter() {
        return jvalueLetter;
    }

    /**
     * Returns true if the type requires 64 bit
     *
     * @return true if the type is a long or a double, false otherwise
     */
    public boolean isDoubleLength() {
        return doubleLength;
    }

    /**
     * Returns true if the type is a value expressed with an IEEE 754 number
     *
     * @return true if the type is a float or a double, false otherwise
     */
    boolean isFloatingPoint() {
        return floatingPoint;
    }

    /**
     * Returns the number of dimensions of an array. The output will be 0 if the type is not an array.
     *
     * @return the number of dimensions of an array. ie. for int[][] aka [[I will return 2
     */
    public int getArrayDepth() {
        return arrayDepth;
    }

    /**
     * Return this parameter as represented in ASM, Reflection, etc..
     *
     * @return The parameters as represented internally (i.e. [[[D, [java/lang/string; ...)
     */
    public String getInternalRepresentation() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayDepth; i++) {
            sb.append("[");
        }
        if (primitiveLetter != 'l') {
            sb.append(Character.toUpperCase(primitiveLetter));
        } else {
            sb.append('L').append(this.name).append(";");
        }
        return sb.toString();
    }

    /**
     * Checks if the two objects are equals
     *
     * @param o The object against which the check will be performed
     * @return true if the two objects are equals, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JniType jniType = (JniType) o;
        return getArrayDepth() == jniType.getArrayDepth() &&
                getName().equals(jniType.getName());
    }

    /**
     * Calculates an hash code for this type.
     *
     * @return The hash code for this class instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getArrayDepth());
    }

    /**
     * Returns the overloaded name for this type.
     * When a function is overloaded, its parameters type are appended in the jni function header as mangled names.
     * This function returns the mangled names of the types.
     *
     * @return The mangled name of a type, as it would appear in a jni header
     */
    public String getOverloadName() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayDepth; i++) {
            sb.append("_3");
        }
        if (primitiveLetter != 'l') {
            //void case
            if (primitiveLetter != '\0') {
                sb.append(Character.toUpperCase(primitiveLetter));
            }
        } else {
            sb.append('L').append(this.name.replaceAll("/", "_")).append("_2");
        }
        return sb.toString();
    }
}
