package eu.fbk.hardening;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseRecursively
{

    public ParseRecursively()
    { }

    public static void main(String[] args)
    {
        if(args.length < 3)
        {
            System.err.println("Missing arguments");
            System.exit(1);
        }
        try
        {
            int[] analyzed = {0};
            long[] ttime = {0};
            Files.walk(Paths.get(args[0])).forEach(a -> {
                    if(a.toString().endsWith(".class"))
                    {
                        try
                        {
                            analyzed[0]++;
                            long t0 =System.currentTimeMillis();
                            JavaToC.parseClass(a.toString(),args[1],args[2],false);
                            long t1 = System.currentTimeMillis();
                            ttime[0]+=t1-t0;
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }

                    }
            });
            System.out.println("Analyzed "+analyzed[0]+" files");
            System.err.print((double)ttime[0]*1.f/1000.f+",");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}