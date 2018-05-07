package eu.fbk.hardening;

import eu.fbk.hardening.support.ClassMethodPair;
import eu.fbk.hardening.support.ExtractedBytecode;
import eu.fbk.hardening.support.ClassMethodPair;
import eu.fbk.hardening.support.ExtractedBytecode;
import eu.fbk.hardening.support.MethodSignature;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

import static org.objectweb.asm.Opcodes.*;

public class ClassBytecodeExtractor extends ClassVisitor
{
    private ArrayList<ClassMethodPair> toObfuscate;
    private String className;
    private ArrayList<MethodBytecodeExtractor> mbe;

    public ClassBytecodeExtractor(ArrayList<ClassMethodPair> obfuscateme)
    {
        super(ASM5);
        this.toObfuscate = obfuscateme;
        this.mbe = new ArrayList<MethodBytecodeExtractor>();
    }

    public ArrayList<ExtractedBytecode> getBytecode()
    {
        ArrayList<ExtractedBytecode> res = new ArrayList<ExtractedBytecode>();
        for(int i=0;i<mbe.size();i++)
            res.add(mbe.get(i).getBytecode());
        return res;
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
            if(desc.equals(cmp.getDesc()) &&
               name.equals(cmp.getMethodName())&&
               this.className.equals((cmp.getClassName()))) //check if method has to be obfuscated
            {
                if(((access & ACC_NATIVE) | (access & ACC_ABSTRACT)) != 0) //check that native method is not annotated with @Obfuscation
                {
                    throw new IllegalPatternException("Can't annotate native method: "+cmp.getClassName()+"."+
                                                      cmp.getMethodName()+cmp.getDesc());
                }
                else
                {
                    MethodBytecodeExtractor met = new MethodBytecodeExtractor((access & ACC_STATIC) > 0);
                    this.mbe.add(met);
                    return met;
                }
            }
        }
        return super.visitMethod(access,name,desc,signature,exceptions);
    }
}
