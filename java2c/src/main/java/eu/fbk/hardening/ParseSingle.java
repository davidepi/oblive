package eu.fbk.hardening;
import java.io.*;

public class ParseSingle
{

    public ParseSingle()
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
            JavaToC.parseClass(args[0],args[1],args[2]);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
