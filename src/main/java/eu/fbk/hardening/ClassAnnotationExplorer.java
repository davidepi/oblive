package eu.fbk.hardening;

import eu.fbk.hardening.support.ClassMethodPair;
import eu.fbk.hardening.support.ClassMethodPair;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;
import java.util.HashMap;

import static org.objectweb.asm.Opcodes.ASM5;

public class ClassAnnotationExplorer extends ClassVisitor
{
    ArrayList<AnnotatedMethodExplorer> obfuscateMethods;
    String name;

    public ClassAnnotationExplorer()
    {
        super(ASM5);
        this.obfuscateMethods = new ArrayList<AnnotatedMethodExplorer>();
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
    {
        this.name = name;
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exception)
    {
            //store every method explorer inside an array + the name. Process them after the visit
            AnnotatedMethodExplorer ame = new AnnotatedMethodExplorer(name,desc);
            this.obfuscateMethods.add(ame);
            return ame;
    }

    public ArrayList<ClassMethodPair> obfuscateThese()
    {
        //when the visit is finished, check for every method if it has the @Obfuscation(protections = Protections.TO_NATIVE_CODE) annotation
        ArrayList<ClassMethodPair> annotated = new ArrayList<ClassMethodPair>();
        //used to count the number of instances of a method, if this is > 1 (accounting only for native methods) then
        // the syntax for overloaded methods must be used
        HashMap<String,Integer> overloadCount = new HashMap<String, Integer>();
        for(int i=0;i<obfuscateMethods.size();i++)
            if(obfuscateMethods.get(i).shouldObfuscate())
            {
                ClassMethodPair cmp = obfuscateMethods.get(i).getMethod();
                cmp.setClassName(this.name);
                annotated.add(cmp);
                if(overloadCount.containsKey(cmp.getMethodName()))
                    overloadCount.put(cmp.getMethodName(),overloadCount.get(cmp.getMethodName())+1); //put oldVal+1
                else
                    overloadCount.put(cmp.getMethodName(),1);
            }
            //record overloaded methods
            for(ClassMethodPair current : annotated)
            {
                if(overloadCount.get(current.getMethodName())>1)
                    current.overloaded = true;
            }
        return annotated;
    }

}
