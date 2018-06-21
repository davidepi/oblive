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
        JavaToC j2c = new JavaToC();
        try
        {
            j2c.startParsing(args[1],args[2]);
            j2c.parseClass(args[0]);
            j2c.endParsing();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
