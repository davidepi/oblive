package it.se.obfuscator;

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
        byte[][] classes = new byte[parse.length][];
        for(int i=0;i<parse.length;i++)
        {
            io = new FileInputStream(parse[i]);
            cr = new ClassReader(io);

            //first pass, visit annotated methods
            cae = new ClassAnnotationExplorer();
            cr.accept(cae,0);
            ArrayList<ClassMethodPair> toProcess = cae.obfuscateThese();

//            cw = new ClassWriter(cr,ClassWriter.COMPUTE_MAXS);
//            //classes[i] = cw.toByteArray();
//            io.close();
//            oi = new FileOutputStream(parse[i]);
//            oi.write(cw.toByteArray());
//            oi.close();
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
