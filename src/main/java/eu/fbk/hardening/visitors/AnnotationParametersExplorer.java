package eu.fbk.hardening.visitors;

import eu.fbk.hardening.annotation.Protections;
import org.objectweb.asm.AnnotationVisitor;

/**
 * This class extends the visit of an annotation and can be used to check the parameters of an annotation. More
 * specifically, this class will check the presence of the protections = TO_NATIVE_CODE parameter in order to be sure
 * that the required obfuscation is the Java2C one.
 *
 * @author D.Pizzolotto
 */
public class AnnotationParametersExplorer extends AnnotationVisitor {

    //This will be set as the desired level of obfuscation
    private Protections correctAnnotation;

    /**
     * Class constructor, setup the parameters for this class
     *
     * @param version The ASM version that will be used
     */
    public AnnotationParametersExplorer(int version) {
        super(version);
        correctAnnotation = Protections.NONE;
    }

    /**
     * Returns the level of protection requested
     *
     * @return the value of the enum protections set by the user
     */
    public Protections getObfuscation() {
        return correctAnnotation;
    }

    /**
     * Checks the enum value of the annotation in order to detect the presence of the TO_NATIVE_CODE or ANTIDEBUG
     * inside the protections enum
     *
     * @param name  The name of the enum
     * @param desc  The class descriptor of the enumeration class
     * @param value The value of the enum
     */
    @Override
    public void visitEnum(String name, String desc, String value) {
        //FIXME: the hardcoded name is fragile, but there isn't a proper way to get the name of a variable from a Class
        if (name.equals("protections")) {
            Protections curVal = Protections.valueOf(value);
            if (curVal == Protections.TO_NATIVE_CODE || curVal == Protections.ANTIDEBUG) {
                correctAnnotation = curVal;
            }
        }
        super.visitEnum(name, desc, value);
    }
}
