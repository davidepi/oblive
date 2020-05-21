package it.oblive.support;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

/**
 * Class used to retrieve some system information, in order to generate (and compile) the os-dependent features of the
 * C accordingly
 *
 * @author D.Pizzolotto
 */
public class SystemInfo {

    /**
     * Extension for object files used by the system
     */
    private static final String objext;

    /**
     * Extension for dynamic library files used by the system
     */
    private static final String libext;

    /**
     * Contains the value of the OS represented as a number:
     * 0. windows
     * 1. mac
     * 2. linux
     * <p>
     * No new enum file for just 3 numbers
     */
    private final static int OS;

    static {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            OS = 0;
            objext = ".obj";
            libext = ".dll";
        } else if (os.contains("mac")) {
            OS = 1;
            objext = ".o";
            libext = ".dylib";
        } else if (os.contains("nix") || os.contains("nux") || os.indexOf("aix") > 0) {
            OS = 2;
            objext = ".o";
            libext = ".so";
        } else
            throw new IncompleteConfigurationError("Unsupported OS (only windows, linux and mac are supported)");
    }

    /**
     * Checks whether the system is windows or not
     *
     * @return true if the system is Windows NT, false otherwise
     */
    @Contract(pure = true)
    public static boolean isWindows() {
        return OS == 0;
    }

    /**
     * Checks whether the system is macOS or not
     *
     * @return true if the system is macOS or OS X, false otherwise
     */
    @Contract(pure = true)
    public static boolean isMacOS() {
        return OS == 1;
    }

    /**
     * Checks whether the system is Linux or not
     *
     * @return true if the system is Linux or any kind of *nix derivative EXCLUDING the Darwin family, false otherwise
     */
    @Contract(pure = true)
    public static boolean isLinux() {
        return OS == 2;
    }

    /**
     * Checks whether the system is *nix or not
     *
     * @return true if the system is Linux or any kind of *nix derivative INCLUDING the Darwin family, false otherwise
     */
    public static boolean isNix() {
        return isMacOS() || isLinux();
    }

    /**
     * Returns the default extension of a compiled object file
     *
     * @return The extension of a compiled file
     */
    @Contract(pure = true)
    public static String getObjectExtension() {
        return objext;
    }

    /**
     * Returns the default extension of a shared library file
     *
     * @return The extension of a shared library
     */
    @Contract(pure = true)
    public static String getSharedLibraryExtension() {
        return libext;
    }


    /**
     * Perform the same operation of the `which` command on linux, thus locating an executable invokable directly by the
     * command line
     *
     * @param executable The name of the executable that will be searched
     * @return The absolute path of the executable if existing, null otherwise
     */
    @Nullable
    public static String which(@NotNull final String executable) {
        String path = System.getenv("PATH");
        if (path == null)
            throw new IncompleteConfigurationError("There is no PATH variable in your OS. Something is nasty");
        String[] paths = path.split(File.pathSeparator);
        for (String current : paths) {
            File test = new File(current + File.separator + executable);
            if (test.exists() && test.canExecute())
                return test.getAbsolutePath();
        }
        return null;
    }
}
