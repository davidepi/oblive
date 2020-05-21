package it.oblive.support;

import org.jetbrains.annotations.NotNull;

/**
 * Class representing the error that will be thrown in case some serious problem with the configuration exists.
 * These can include unsupported OS, missing compiler for the tests... etc.
 *
 * @author D.Pizzolotto
 */
public class IncompleteConfigurationError extends Error {


    /**
     * Exception constructor
     *
     * @param message The message that will be bundled with the exception
     */
    public IncompleteConfigurationError(@NotNull String message) {
        super(message);
    }
}
