package it.se.obfuscator;

import it.se.obfuscator.support.ClassMethodPair;
import it.se.obfuscator.support.ExtractedBytecode;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.*;
import java.util.ArrayList;

public class Java2CMain
{

    public Java2CMain()
    { }

    private void parseClass(final String[] parse) throws IOException
    {
        InputStream io;
        OutputStream oi;
        ClassReader cr;
        ClassWriter cw;
        ClassAnnotationExplorer cae;
        ClassBytecodeExtractor cbe;
        ClassCodeElimination cce;
        byte[][] classes = new byte[parse.length][];
        for(int i=0;i<parse.length;i++)
        {
            io = new FileInputStream(parse[i]);
            cr = new ClassReader(io);
            cw = new ClassWriter(cr,0);

            //first pass, visit annotated methods
            cae = new ClassAnnotationExplorer();
            cr.accept(cae,0);
            ArrayList<ClassMethodPair> toProcess = cae.obfuscateThese();
            if(toProcess.size()==0) //nothing to obfuscate in this class
            {
                io.close();
                continue;
            }

            //second pass, extract instructions from methods
            cbe = new ClassBytecodeExtractor(toProcess);
            cr.accept(cbe,0);
            ArrayList<ExtractedBytecode> eb = cbe.getBytecode();

            //third pass, modify the class by removing the methods' bodies and adding static init
            cce = new ClassCodeElimination(toProcess,cw);
            cr.accept(cce,0);

            //next step: convert the ExtractedBytecode to actual c code
            String c = "#include <jni.h>\n#include \"obframework.h\"\n\n";
            for(int j=0;j<eb.size();j++)
            {
                ClassMethodPair cmp = toProcess.get(i);
                ExtractedBytecode bytecode = eb.get(i);
                c += CSourceGenerator.generateCode(cmp.getClassName(),cmp.getMethodName(),cmp.getSignature(),bytecode);
            }
            PrintWriter pw = new PrintWriter(parse[i]+".c");
            pw.write(c);
            pw.close();

            classes[i] = cw.toByteArray();
            io.close();
            oi = new FileOutputStream(parse[i]);
            oi.write(cw.toByteArray());
            oi.close();
        }
    }

    public static void main(String[] args)
    {
        if(args.length < 1)
        {
            System.err.println("Missing argument: class names");
            System.exit(1);
        }
        try
            {new Java2CMain().parseClass(args);}
        catch (IOException e)
            {e.printStackTrace();}
    }
}
