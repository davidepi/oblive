package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowArrayLoadOutOfBoundsByte {
    private byte[] array;

    public ThrowArrayLoadOutOfBoundsByte() {
        this.array = new byte[2];
    }

    @NativeObfuscation
    public byte exec() {
        return this.array[2];
    }
}
