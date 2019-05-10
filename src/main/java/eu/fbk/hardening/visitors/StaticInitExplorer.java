package eu.fbk.hardening.visitors;

import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.RETURN;

/**
 * This visitor is used to add the loadLibrary used to load dynamically the generated C library.
 *
 * @author D.Pizzolotto
 */
public class StaticInitExplorer extends MethodVisitor {
    private String libname;

    /**
     * Default constructor
     *
     * @param version ASM version
     * @param mv      original method visitor
     * @param libname name of the library
     */
    public StaticInitExplorer(int version, MethodVisitor mv, @NotNull String libname) {
        super(version, mv);
        this.libname = libname.replace('/', '.');
    }

    @Override
    public void visitInsn(int opcode) {
        //end of the static block
        if (opcode == RETURN) {
            super.visitLdcInsn(libname);
            super.visitMethodInsn(INVOKESTATIC, "java/lang/System", "loadLibrary", "(Ljava/lang/String;)V", false);
        }
        super.visitInsn(opcode);
    }

    @Override
    public void visitMaxs(int maxStack, int maxVars) {
        //since one string will be pushed onto the stack
        super.visitMaxs(maxStack + 1, maxVars);
    }
}
