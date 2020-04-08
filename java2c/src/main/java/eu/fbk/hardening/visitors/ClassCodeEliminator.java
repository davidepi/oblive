package eu.fbk.hardening.visitors;


import eu.fbk.hardening.support.ClassMethodPair;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;

/**
 * This visitor is used to visit a class and remove the body of a method from it. Additionally this class calls the
 * StaticInitExplorer one to visit the static init block and add the library for the method for which the body has been
 * stripped.
 *
 * @author D.Pizzolotto
 */
public class ClassCodeEliminator extends ClassVisitor {

    //list of methods that should be obfuscated
    private ArrayList<ClassMethodPair> toObfuscate;
    //name of the class
    private String className;
    //name of the library that should be linked with this class, containing the code for the stripped methods
    private String libName;
    //true if this method has a static init block, false otherwise
    private boolean hasStaticInit;
    //ASM version
    private int version;

    /**
     * Default constructor
     *
     * @param version     ASM version to be used
     * @param obfuscateme list of methods that should be obfuscated
     * @param libname     name of the library that will be linked with this class. The one containing the c code for the
     *                    stripped methods
     * @param cw          The ClassWriter that will write this modified class (withouth the body for the obfuscated
     *                    methods)
     */
    public ClassCodeEliminator(int version, ArrayList<ClassMethodPair> obfuscateme, String libname, ClassWriter cw) {
        super(version, cw);
        this.toObfuscate = obfuscateme;
        this.hasStaticInit = false; //this will be set at true if the <clinit> is encountered during method visiting
        this.libName = libname;
        this.version = version;
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
        super.visit(version, access, name, signature, superName, interfaces);
    }

    /**
     * Visits a method and removes the body from it if this method was marked as obfuscated.
     * In the case the visited method is the &lt;clinit&gt; the import for the library is added to it. Otherwise the
     * &lt;clinit&gt; method is crafted manually in the visitEnd() method
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
        //static init, special case
        if (name.equals("<clinit>") && desc.equals("()V")) {
            hasStaticInit = true;
            //add the library import while visiting static init
            MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
            return new StaticInitExplorer(version, mv, libName);
        }

        //check if obfuscated
        for (ClassMethodPair annotatedMethod : toObfuscate) {
            if (desc.equals(annotatedMethod.getDesc()) && name.equals(annotatedMethod.getMethodName())
                    && this.className.equals((annotatedMethod.getClassName()))) { //check if method has to be obfuscated
                //alter the method declaration by adding native
                super.visitMethod(access | Opcodes.ACC_NATIVE, name, desc, signature, exceptions);
                //but return empty body
                return null;
            }
        }
        //otherwise return the method
        return super.visitMethod(access, name, desc, signature, exceptions);
    }

    /**
     * Concludes the visit at the class and add the static import if it was not found (and thus not visited in the
     * visitMethod step)
     */
    @Override
    public void visitEnd() {
        if (!hasStaticInit) { //missing static import, craft manually
            MethodVisitor mv = super.visitMethod(Opcodes.ACC_STATIC, "<clinit>", "()V", null, null);
            mv.visitCode();
            mv.visitLdcInsn(libName);
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "loadLibrary", "(Ljava/lang/String;)V", false);
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(1, 0);
            mv.visitEnd();
        }
        super.visitEnd();
    }
}
