package it.se.callgraph;

import it.se.callgraph.obfuscator.ClassExplorer;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.*;

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
        ClassExplorer ca;
        byte[][] classes = new byte[parse.length][];
        for(int i=0;i<parse.length;i++)
        {
            io = new FileInputStream(parse[i]);
            cr = new ClassReader(io);
            cw = new ClassWriter(cr,ClassWriter.COMPUTE_MAXS);
            ca = new ClassExplorer(cw,parse[i]+".native");
            cr.accept(ca,0);
            //classes[i] = cw.toByteArray();
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
