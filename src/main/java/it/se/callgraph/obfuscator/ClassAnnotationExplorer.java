package it.se.callgraph.obfuscator;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;

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
            AnnotatedMethodExplorer ame = new AnnotatedMethodExplorer("::"+name+desc);
            this.obfuscateMethods.add(ame);
            return ame;
    }

    public ArrayList<String> obfuscateThese()
    {
        //when the visit is finished, check for every method if it has the @Obfuscate annotation
        ArrayList<String> annotated = new ArrayList<String>();
        for(int i=0;i<obfuscateMethods.size();i++)
            if(obfuscateMethods.get(i).shouldObfuscate())
                annotated.add(this.name+obfuscateMethods.get(i).getMethodName());
        return annotated;
    }

}
