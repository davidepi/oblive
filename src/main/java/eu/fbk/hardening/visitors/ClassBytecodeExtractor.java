package eu.fbk.hardening.visitors;

import eu.fbk.hardening.support.ClassMethodPair;
import eu.fbk.hardening.support.ExtractedBytecode;
import eu.fbk.hardening.support.IllegalPatternException;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ACC_STATIC;

/**
 * Visitor used to inspect the a class and translate in a 1:1 manner every method that should be obfuscated, from the
 * Java Bytecode to the JNI C code
 *
 * @author D.Pizzolotto
 */
public class ClassBytecodeExtractor extends ClassVisitor {

    //list of methods that should be obfuscated
    private ArrayList<ClassMethodPair> toObfuscate;
    //name of this class
    private String className;
    //list of method visitors that extracts the bytecode, used for later retrieval of the data
    private ArrayList<MethodBytecodeExtractor> mbe;
    //ASM version
    private int asmVersion;

    /**
     * Default constructor
     *
     * @param version     the ASM version that will be used
     * @param obfuscateme the list of methods that should be obfuscated
     */
    public ClassBytecodeExtractor(int version, ArrayList<ClassMethodPair> obfuscateme) {
        super(version);
        this.toObfuscate = obfuscateme;
        this.mbe = new ArrayList<>();
        this.asmVersion = version;
    }

    /**
     * Get the bytecode extracted from these methods. Every element of the ArrayList correspond to a single method
     *
     * @return An ArrayList containing the extracted bytecode for every method.
     */
    public ArrayList<ExtractedBytecode> getBytecode() {
        ArrayList<ExtractedBytecode> res = new ArrayList<>();
        for (MethodBytecodeExtractor currentMethod : mbe) {
            res.add(currentMethod.getBytecode());
        }
        return res;
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
     * Visits a method and call a MethodBytecodeExtractor for each one of them matching the following:
     * - not native
     * - not a constructor
     * - annotated with the @Obfuscate annotation
     * This MethodBytecodeExtractor reads 1:1 the opcodes and replaces them with the C implementation.
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
        for (ClassMethodPair annotatedMethod : toObfuscate) {
            if (desc.equals(annotatedMethod.getDesc()) && name.equals(annotatedMethod.getMethodName())
                    && this.className.equals((annotatedMethod.getClassName()))) { //check if method has to be obfuscated
                //check that native method is not annotated with @Obfuscation(protections = Protections.TO_NATIVE_CODE)
                if (((access & ACC_NATIVE) | (access & ACC_ABSTRACT)) != 0) {
                    throw new IllegalPatternException("Can't annotate native method: " + annotatedMethod.getClassName()
                            + "." + annotatedMethod.getMethodName() + annotatedMethod.getDesc());
                } else {
                    MethodBytecodeExtractor met;
                    met = new MethodBytecodeExtractor(asmVersion, (access & ACC_STATIC) > 0);
                    this.mbe.add(met);
                    return met;
                }
            }
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}
