package eu.fbk.hardening;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseRecursively
{

    public ParseRecursively()
    { }

    /**
     * Parse every Class file inside a folder to apply the Java2c obfuscation.
     * Each file is overwritten with its obfuscated counterpart
     * @param args 0 - The folder containing the Class files
     *             1 - Output folder for the output C source file
     *             2 - Name of the library that will be linked against every Class file (without `lib` and `.so`)
     */
    public static void main(String[] args)
    {
        if(args.length < 3)
        {
            System.err.println("Missing arguments");
            System.exit(1);
        }
        JavaToC j2c = new JavaToC();
        try
        {
            int[] analyzed = {0};
            long[] ttime = {0};
            j2c.startParsing(args[1],args[2]);
            Files.walk(Paths.get(args[0])).forEach(a -> {
                    if(a.toString().endsWith(".class"))
                    {
                        try
                        {
                            analyzed[0]++;
                            long t0 =System.currentTimeMillis();
                            j2c.parseClass(a.toString());
                            long t1 = System.currentTimeMillis();
                            ttime[0]+=t1-t0;
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }

                    }
            });
            j2c.endParsing();
            System.out.println("Analyzed "+analyzed[0]+" files");
            System.err.print((double)ttime[0]*1.f/1000.f+",");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}