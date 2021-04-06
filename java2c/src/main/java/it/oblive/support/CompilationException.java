package it.oblive.support;

import org.jetbrains.annotations.NotNull;

/**
 * Class representing the error that will be thrown in case the generated file can not compile.
 *
 * @author D.Pizzolotto
 */
public class CompilationException extends Exception {

    private String outfile;

    /**
     * Exception constructor
     *
     * @param outfile The output file that was expected
     * @param message The message that will be bundled with the exception
     */
    public CompilationException(@NotNull String outfile, @NotNull String message) {
        super(message);
        this.outfile = outfile;
    }

    /**
     * Return the filename of the file that was expected, but failed compilation.
     */
    public String getExpectedFilename() {
        return this.outfile;
    }
}
