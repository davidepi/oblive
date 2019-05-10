package eu.fbk.hardening.visitors;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.support.ClassMethodPair;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

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

    //true if the annotation with the correct name has been found
    private boolean correctAnnotationName;
    //annotation visitor, in case this annotation name is correct, and the parameters must be checked.
    //This is a list because to add support for multiple annotation with the same name but different parameters
    private ArrayList<AnnotationParametersExplorer> visitorList;
    //name of the current method being visited
    private String methodName;
    //signature of the method being visited
    private String signature;
    //API version
    private int version;

    /**
     * Class constructor. Does nothing but setting parameters
     *
     * @param name    Name of the method being parsed
     * @param sign    Signature of the method being parsed
     * @param version ASM version to use
     */
    public AnnotatedMethodExplorer(int version, String name, String sign) {
        super(version);
        this.version = version;
        this.methodName = name;
        this.signature = sign;
        this.visitorList = new ArrayList<>();
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
        correctAnnotationName = desc.equals("L" + Obfuscation.class.getName().replace('.', '/') + ";");
        if (correctAnnotationName) {
            AnnotationParametersExplorer av = new AnnotationParametersExplorer(version);
            this.visitorList.add(av);
            return av;
        } else
            return super.visitAnnotation(desc, visible);
    }

    /**
     * This method is used to know if the method should be obfuscated or not.
     * <p>
     * If the name is correct, the result of every annotation visitor (that checked the parameters) is checked. If AT
     * LEAST ONE (hence the |) annotation had the correct combination name+parameters means that the annotation was
     * requested for this method.
     *
     * @return true if the method is requested to be obfuscated (the annotation was found), false otherwise
     */
    boolean shouldObfuscate() {
        boolean obfuscate = false;
        if (correctAnnotationName) {
            for (AnnotationParametersExplorer visitor : visitorList) {
                obfuscate |= visitor.toNativeCodeParamFound();
            }
        }
        return obfuscate;
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
