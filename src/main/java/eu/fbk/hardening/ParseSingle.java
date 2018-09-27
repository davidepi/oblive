package eu.fbk.hardening;
import java.io.*;

public class ParseSingle
{

    public ParseSingle()
    { }

    /**
     * Parse a single Class file to apply the Java2c obfuscation.
     * The file is overwritten with its obfuscated counterpart
     * @param args 0 - The file to overwrite
     *             1 - Output folder for the output C source file
     *             2 - Name of the library that will be linked against this Class file (without `lib` and `.so`)
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
