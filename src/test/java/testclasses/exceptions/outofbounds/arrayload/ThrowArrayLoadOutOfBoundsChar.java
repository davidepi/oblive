package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayLoadOutOfBoundsChar {
    private char[] array;

    public ThrowArrayLoadOutOfBoundsChar() {
        this.array = new char[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char exec() {
        return this.array[2];
    }
}
