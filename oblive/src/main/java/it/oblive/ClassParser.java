package it.oblive;

import it.oblive.support.SystemInfo;
import org.jetbrains.annotations.NotNull;

/**
 * Main entry point for the Java2C application, in case a recursive scan of a folder is wanted. Note that the files
 * will be overwritten with the obfuscated version!!!
 *
 * @author D.Pizzolotto
 */
public class ClassParser {

    /**
     * Parse every Class file inside a folder to apply the Java2c obfuscation.
     * Each file is overwritten with its obfuscated counterpart
     *
     * @param args 0 - The folder containing the Class files
     *             1 - Output folder for the output C source file
     *             2 - Name of the library that will be linked against every Class file (without `lib` and `.so`)
     */
    public static void parseRecursively(@NotNull String[] args) {
        //TODO: ADD WINDOWS TO THE ASSERT WHEN IMPLEMENTED
        //assert that the OS is correct (no solaris or some other strange os)
        assert SystemInfo.isLinux() || SystemInfo.isMacOS();

        if (args.length < 3) {
            System.err.println("Missing arguments: <folder containing class files> <output folder of the C library> " +
                    "<name of the C library>");
            System.exit(1);
        }

    }
}