package eu.fbk.hardening.support;

/**
 * Class representing the exception that will be thrown when a non-supported opcode is encountered.
 *
 * @author D.Pizzolotto
 */
public class IllegalPatternException extends Error {

    /**
     * Exception constructor
     *
     * @param message The message that will be bundled with the exception
     */
    public IllegalPatternException(String message) {
        super(message);
    }
}
