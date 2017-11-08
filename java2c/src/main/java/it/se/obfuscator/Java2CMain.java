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

    public void parseClass(final String[] parse) throws IOException
    {
        String output_path = parse[parse.length-1];
        if(output_path.charAt(output_path.length()-1)!=File.separatorChar)
            output_path+=File.separator;
        output_path+="libsrc"+File.separator;
        File output_file = new File(output_path); //create output directory
        if(!output_file.mkdirs())
            throw new IOException();
        InputStream io;
        OutputStream oi;
        ClassReader cr;
        ClassWriter cw;
        ClassAnnotationExplorer cae;
        ClassBytecodeExtractor cbe;
        ClassCodeElimination cce;
        for(int i=0;i<parse.length-1;i++) //last element is the output dir
        {
            io = new FileInputStream(parse[i]);
            cr = new ClassReader(io);

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
            cw = new ClassWriter(cr,0);
            cce = new ClassCodeElimination(toProcess,cw);
            cr.accept(cce,0);

            //next step: convert the ExtractedBytecode to actual c code
            String c = "#include <jni.h>\n#include \"obframework.h\"\n\n";

            for(int j=0;j<eb.size();j++)
            {
                ClassMethodPair className = toProcess.get(i);;
                ExtractedBytecode bytecode = eb.get(i);
                c += CSourceGenerator.generateCode(className.getClassName(),className.getMethodName(),className.getSignature(),bytecode);
            }
            PrintWriter pw = new PrintWriter(output_path+"libobf.c");
            pw.write(c);
            pw.close();

            io.close();
            oi = new FileOutputStream(parse[i]);
            oi.write(cw.toByteArray());
            oi.close();
        }
    }

    public static void main(String[] args)
    {
        if(args.length < 2)
        {
            System.err.println("Missing arguments");
            System.exit(1);
        }
        try
            {new Java2CMain().parseClass(args);}
        catch (IOException e)
            {e.printStackTrace();}
    }
}
