package it.oblive.support;

import org.jetbrains.annotations.NotNull;

/**
 * Class representing the exception that will be thrown when a non-supported opcode is encountered.
 *
 * @author D.Pizzolotto
 */
public class IllegalPatternError extends Error {

    /**
     * Exception constructor
     *
     * @param message The message that will be bundled with the exception
     */
    public IllegalPatternError(@NotNull String message) {
        super(message);
    }
}
