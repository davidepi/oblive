package eu.fbk.hardening;

import eu.fbk.hardening.support.SystemInfo;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Main entry point for the Java2C application, in case just a single file needs to be transformed
 *
 * @author D.Pizzolotto
 */
public class ParseSingle {

    /**
     * Parse a single Class file to apply the Java2c obfuscation.
     * The file is overwritten with its obfuscated counterpart
     *
     * @param args 0 - The file to overwrite
     *             1 - Output folder for the output C source file
     *             2 - Name of the library that will be linked against this Class file (without `lib` and `.so`)
     */
    public static void main(@NotNull String[] args) {
        //TODO: ADD WINDOWS TO THE ASSERT WHEN IMPLEMENTED
        //assert that the OS is correct (no solaris or some other strange os)
        assert SystemInfo.isLinux() || SystemInfo.isMacOS();

        if (args.length < 3) {
            System.err.println("Missing arguments");
            System.exit(1);
        }
        JavaToC j2c = new JavaToC();
        try {
            j2c.startParsing(args[1], args[2]);
            j2c.parseClass(args[0]);
            j2c.endParsing();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
