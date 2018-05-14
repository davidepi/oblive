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
            Files.walk(Paths.get(args[0])).forEach(a -> {
                    if(a.toString().endsWith(".class"))
                    {
                        try
                        {
                            JavaToC.parseClass(a.toString(),args[1],args[2]);
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }

                    }
            });
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}