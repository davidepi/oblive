package eu.fbk.hardening.visitors;


import eu.fbk.hardening.support.ClassMethodPair;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.HashSet;

/**
 * This class extends the visit of a method by ASM and searches for the annotation responsible for enabling the
 * bytecode to native translation. In order for the annotation to be correct, both the following conditions must be
 * checked:
 * - The annotation name should be correct
 * - The annotation parameters should be correct
 * This because XorMask shares the same annotation name but requires different parameters.
 * <p>
 * This class performs these checks and returns the result via the shouldObfuscate() method
 *
 * @author D.Pizzolotto
 */
public class AnnotatedMethodExplorer extends MethodVisitor {

    // annotation names found for this method
    private HashSet<String> annotationNames;
    //name of the current method being visited
    private String methodName;
    //signature of the method being visited
    private String signature;

    /**
     * Class constructor. Does nothing but setting parameters
     *
     * @param name      Name of the method being parsed
     * @param signature Signature of the method being parsed
     * @param version   ASM version to use
     */
    public AnnotatedMethodExplorer(int version, String name, String signature) {
        super(version);
        this.methodName = name;
        this.signature = signature;
        this.annotationNames = new HashSet<>();
    }

    /**
     * Checks the annotation of the current method
     *
     * @param desc    The class description of the annotation
     * @param visible true if the annotation is visible at runtime
     * @return a visitor of the annotation. In this case the superclass visitor, since visiting the annotation is
     * redundant
     */
    @Override
    public AnnotationVisitor visitAnnotation(@NotNull String desc, boolean visible) {
        // ease the comparison for later by transforming the ASM syntax to the java one
        String newdesc = desc.replace('/', '.');
        newdesc = newdesc.substring(1, newdesc.length() - 1); // remove the L and ;
        annotationNames.add(newdesc);
        return super.visitAnnotation(desc, visible);
    }

    /**
     * Check if a particular annotation is applied to this method
     * This method is used to know if the method should be obfuscated or not
     *
     * @param annotation The annotation that will be checked
     * @return true if the method is requested to be obfuscated (the annotation was found), false otherwise
     */
    boolean containsAnnotation(Class<?> annotation) {
        return annotationNames.contains(annotation.getName());
    }

    /**
     * Returns information about the current method being parsed in form of a ClassMethodPair class.
     * Class name is not available at this point and will be added later
     *
     * @return information about the current method being parsed
     */
    public ClassMethodPair getMethod() {
        return new ClassMethodPair("", methodName, signature);
    }
}
