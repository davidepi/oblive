package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowArrayLoadOutOfBoundsChar {
    private char[] array;

    public ThrowArrayLoadOutOfBoundsChar() {
        this.array = new char[2];
    }

    @NativeObfuscation
    public char exec() {
        return this.array[2];
    }
}
