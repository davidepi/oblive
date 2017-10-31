package it.se.obfuscator;

import it.se.obfuscator.support.ClassMethodPair;
import it.se.obfuscator.support.ExtractedBytecode;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

import static org.objectweb.asm.Opcodes.ACC_NATIVE;
import static org.objectweb.asm.Opcodes.ASM5;

public class ClassBytecodeExtractor extends ClassVisitor
{
    private ArrayList<ClassMethodPair> toObfuscate;
    private String className;
    private MethodBytecodeExtractor mbe;

    public ClassBytecodeExtractor(ArrayList<ClassMethodPair> obfuscateme)
    {
        super(ASM5);
        this.toObfuscate = obfuscateme;
    }

    public ExtractedBytecode getBytecode()
    {
        return mbe.getBytecode();
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
    {
        this.className = name;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
    {
        for(int i=0;i<toObfuscate.size();i++)
        {
            ClassMethodPair cmp = toObfuscate.get(i);
            if(desc.equals(cmp.getSignature()) &&
               name.equals(cmp.getMethodName())&&
               this.className.equals((cmp.getClassName()))) //check if method has to be obfuscated
            {
                if((access & ACC_NATIVE) != 0) //check that native method is not annotated with @Obfuscate
                {
                    System.err.println("Can't annotate native methods");
                    System.exit(1);
                }
                else
                {
                    this.mbe = new MethodBytecodeExtractor();
                    return this.mbe;
                }
            }
        }
        return super.visitMethod(access,name,desc,signature,exceptions);
    }
}
