package eu.fbk.hardening.visitors;

import eu.fbk.hardening.annotation.NativeObfuscation;
import eu.fbk.hardening.support.ClassMethodPair;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class extends the ASM ClassVisitor and is used to visit classes and search for methods containing the specific
 * annotation used to request a bytecode to native code translation. This class in turn will call the
 * AnnotatedMethodExplorer visitors for every method found.
 *
 * @author D.Pizzolotto
 */
public class ClassAnnotationExplorer extends ClassVisitor {

    //A list of method to be visited looking for annotations (in form of AnnotatedMethodExplorer)
    private ArrayList<AnnotatedMethodExplorer> obfuscateMethods;
    //The name of the class being visited
    private String className;
    //the asm version that will be used
    private int asmVersion;

    /**
     * Default constructor, used to initialize and set parameters
     *
     * @param version ASM version to be used
     */
    public ClassAnnotationExplorer(int version) {
        super(version);
        this.asmVersion = version;
        this.obfuscateMethods = new ArrayList<>();
    }

    /**
     * Visit this class and records some information about it (just the name)
     *
     * @param version    ASM version (UNUSED)
     * @param access     class flags, for example the final modifier (UNUSED)
     * @param name       name of the class
     * @param signature  the signature of this class (UNUSED)
     * @param superName  name of the class superclass (UNUSED)
     * @param interfaces name of the class interfaces(UNUSED)
     */
    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name;
    }


    /**
     * Visits a method and call an AnnotatedMethodExplorer for each one of them, used to search for the annotations
     *
     * @param access     method access flags, for example static, final... (UNUSED)
     * @param name       name of the method
     * @param desc       description of the method
     * @param signature  signature of the method (UNUSED)
     * @param exceptions internal name of the method exception (UNUSED)
     * @return A method visitor used to visit a method and its
     */
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        //store every method explorer inside an array + the name. Process them after the visit
        AnnotatedMethodExplorer ame = new AnnotatedMethodExplorer(asmVersion, name, desc);
        //add the visitor to this class so it is possible later to retrieve its information
        this.obfuscateMethods.add(ame);
        return ame;
    }

    /**
     * Retrieves the information about methods that should be obfuscated. This method should be called after the visit
     *
     * @return The list of methods that should be obfuscated, in form of ClassMethodPair
     */
    public ArrayList<ClassMethodPair> obfuscateThese() {
        //when the visit is finished, check for every method if it has the @Obfuscation annotation
        ArrayList<ClassMethodPair> annotated = new ArrayList<>();
        //used to count the number of instances of a method, if this is > 1 (accounting only for native methods) then
        //the syntax for overloaded methods must be used
        HashMap<String, Integer> overloadCount = new HashMap<>();
        for (AnnotatedMethodExplorer method : obfuscateMethods) {
            if (method.containsAnnotation(NativeObfuscation.class)) {
                ClassMethodPair cmp = method.getMethod();
                cmp.setClassName(this.className);
                annotated.add(cmp);
                //set the number of overloaded methods with this name
                if (overloadCount.containsKey(cmp.getMethodName())) {
                    overloadCount.put(cmp.getMethodName(), overloadCount.get(cmp.getMethodName()) + 1); //put oldVal+1
                } else {
                    overloadCount.put(cmp.getMethodName(), 1);
                }
            }
        }
        //record overloaded methods
        for (ClassMethodPair current : annotated) {
            if (overloadCount.get(current.getMethodName()) > 1) {
                current.overloaded = true;
            }
        }
        return annotated;
    }

}
