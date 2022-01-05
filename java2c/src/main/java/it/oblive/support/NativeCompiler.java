package it.oblive.support;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Class responsible for spawning a compiling process (and therefore detecting a compiler) in order to compile the
 * native .c file into a shared library required by the JVM.
 * <p>
 * The compiler that will be used is the one found inside the CC environment variable. If that's not available, it will
 * fallback to the result of `which gcc` for unix systems and TODO:WHAT WILL I DO ON WINDOWS?
 *
 * @author D.Pizzolotto
 */
public class NativeCompiler {

    private String cflags;
    private String compiler;
    private String include;
    private final String objext;
    private final String libext;
    private String linklibs;

    /**
     * Default constructor
     */
    public NativeCompiler() {
        cflags = "";
        linklibs = "";
        objext = SystemInfo.getObjectExtension();
        libext = SystemInfo.getSharedLibraryExtension();
        if (SystemInfo.isNix())
            initNix();
        else
            initWin();
    }

    /**
     * Initialize parameters for macOS and Linux systems
     */
    private void initNix() {
        compiler = System.getenv("CC");
        if (compiler == null) {
            compiler = SystemInfo.which("gcc");
            if (compiler == null) {
                throw new IncompleteConfigurationError("The CC environment variable used to specify the C " +
                        "compiler is not set. Tried to fallback to gcc but could not be found");
            }
        }
        String javaHome = System.getenv("JAVA_HOME");
        if (javaHome == null) {
            javaHome = System.getProperty("java.home");
            if (javaHome.isEmpty()) {
                throw new IncompleteConfigurationError("The JAVA_HOME environment variable used to specify the " +
                        "JDK/JRE home is not set");
            }
        } else {
            //in some cases gradle is configured to return the quoted JAVA_HOME string. I don't want quotes
            javaHome = javaHome.replaceAll("\"", "");
        }
        try {
            final String[] includes = new String[]{null, null};
            //sometimes the javaHome is a symlink to the correct version, so I need to follow links
            Files.walk(Paths.get(javaHome), FileVisitOption.FOLLOW_LINKS)
                    .filter(Files::isRegularFile)
                    .forEach((f) -> {
                        String file = f.toString();
                        if (file.endsWith("jni.h"))
                            includes[0] = f.getParent().toString();
                        else if (file.endsWith("jni_md.h"))
                            includes[1] = f.getParent().toString();
                    });
            if (includes[0] == null)
                throw new IOException("Could not find the file `jni.h` in the JAVA_HOME subtree");
            else if (includes[1] == null)
                throw new IOException("Could not find the file `jni_md.h` in the JAVA_HOME subtree");
            else
                include = "-I" + includes[0] + " -I" + includes[1];
        } catch (IOException e) {
            throw new IncompleteConfigurationError("Could not find the file `jni.h` in the JAVA_HOME subtree");
        }
    }

    /**
     * Compiles a series of source files into object files
     *
     * @param sources      A list of File that will be passed to the compiler
     * @param objectOutput The output of the compilation process. If the extension is wrong or missing it will be added
     *                     (by modifying this object). Note that if the output is already existent it will be replaced.
     * @param executable   true if the file have a main. Otherwise the -c -fpic flags are added.
     * @throws IOException          in case the source files are not readable or with the wrong extension (only .c, folks)
     * @throws CompilationException if there was an error during compilation
     * @throws InterruptedException if the compilation was interrupted externally
     */
    public void compileFile(final File[] sources, @NotNull File objectOutput, boolean executable) throws IOException,
            CompilationException, InterruptedException {
        //TODO: ASSERT THAT THIS WORKS ON WINDOWS

        //assert existence of folder if it is not the current one
        if (objectOutput.getParentFile() != null) {
            boolean created = objectOutput.getParentFile().mkdirs();
        }
        //append extension if does not exists or it is wrong
        if (!objectOutput.getAbsolutePath().endsWith(objext))
            objectOutput = new File(objectOutput.getAbsolutePath() + objext);

        StringBuilder command = new StringBuilder(compiler);
        if (!executable) {
            command.append(" -c -fpic ");
        }
        command.append(' ').append(include).append(' ');

        for (File source : sources) {
            //the .c limitation is used to clearly separate this method from the compileSharedLib
            if (!source.getAbsolutePath().endsWith(".c")) {
                throw new IOException("Only .c files can be compiled. Please change extension of " +
                        source.getAbsolutePath());
            } else if (source.exists() && source.canRead()) {
                command.append(' ').append(source.getAbsolutePath()).append(' ');
            } else {
                throw new IOException("Requested compilation of " + source.getAbsolutePath() + " but it can not be " +
                        "read or does not exists");
            }
        }
        command.append(' ').append(linklibs).append(' ').append(cflags).append(' ').append("-o ");
        command.append(objectOutput.getAbsolutePath());
        runCompilation(command.toString(), objectOutput.getAbsolutePath());
    }

    /**
     * Compiles a series of object files into a library
     *
     * @param sources       A list of File that will be passed to the compiler
     * @param libraryOutput The output of the compilation process. If the extension is wrong or missing it will be added
     *                      (by modifying this object). Note that if the output is already existent it will be replaced.
     * @throws IOException          in case the source files are not readable or with the wrong extension
     * @throws CompilationException if there was an error during compilation
     * @throws InterruptedException if the compilation was interrupted externally
     */
    public void compileSharedLib(File[] sources, @NotNull File libraryOutput)
            throws IOException, CompilationException, InterruptedException {
        //TODO: ASSERT THAT THIS WORKS ON WINDOWS

        //assert existence of folder if it is not the current one
        if (libraryOutput.getParentFile() != null) {
            boolean created = libraryOutput.getParentFile().mkdirs();
        }
        //append extension if does not exists or it is wrong
        if (!libraryOutput.getAbsolutePath().endsWith(libext))
            libraryOutput = new File(libraryOutput.getAbsolutePath() + libext);

        StringBuilder command = new StringBuilder(compiler);

        for (File source : sources) {
            if (!source.getAbsolutePath().endsWith(objext)) {
                throw new IOException("Requested shared library but the input file " + source.getAbsolutePath() +
                        " is not an object file.");
            } else if (source.exists() && source.canRead()) {
                command.append(' ').append(source.getAbsolutePath()).append(' ');
            } else {
                throw new IOException("Requested compilation but the file " + source.getAbsolutePath() + " can't be " +
                        "read or does not exists");
            }
        }
        command.append(' ').append(linklibs).append(' ').append(cflags).append(' ').append(" -shared -o ");
        command.append(libraryOutput.getAbsolutePath());
        runCompilation(command.toString(), libraryOutput.getAbsolutePath());
    }

    /**
     * Spawn a process that runs the given command
     *
     * @param command The command that will be run
     * @throws IOException          when it is not possible to spawn a process
     * @throws CompilationException if the compiler generated an error
     * @throws InterruptedException if the compilation was interrupted by other means
     */
    private void runCompilation(@NotNull String command, @NotNull String expectedOutput) throws IOException, CompilationException, InterruptedException {
        String retval;
        String trimmedCommand = command.replaceAll("\\s+", " ");
        String[] commandArray = trimmedCommand.split(" ");
        ProcessBuilder compilationProcess = new ProcessBuilder(commandArray);
        Process child = compilationProcess.start();
        child.waitFor();
        if (child.exitValue() != 0) {
            //read compilation message
            retval = new BufferedReader(new InputStreamReader(child.getErrorStream())).lines()
                    .collect(Collectors.joining("\n"));
            throw new CompilationException(expectedOutput, retval);
        }
    }

    /**
     * Sets the following flags that will be used when invoking the compileFile method.
     *
     * @param flags the flags that will be used
     */
    public void setCompilationFlags(@NotNull String flags) {
        this.cflags = flags;
    }

    /**
     * Sets the static libraries that will be used for the compilation.
     * Libraries are passed with their complete name, for example ["libssl", "libcrypto"] etc..
     *
     * @param staticLibs the name of the library that will be linked by the linker. Name must start with "lib".
     */
    public void setStaticLibs(@NotNull String[] staticLibs) {
        StringBuilder sb = new StringBuilder();
        for (String lib : staticLibs) {
            if (lib.startsWith("lib")) {
                sb.append("-l").append(lib.substring(3));
            } else {
                throw new AssertionError("Full library name not specified");
            }
        }
        this.linklibs = sb.toString();
    }

    /**
     * Init parameters for Windows systems
     */
    @Contract(" -> fail")
    private void initWin() {
        //TODO: ADD WINDOWS SUPPORT
        throw new UnsupportedOperationException("Add windows support");
    }
}
