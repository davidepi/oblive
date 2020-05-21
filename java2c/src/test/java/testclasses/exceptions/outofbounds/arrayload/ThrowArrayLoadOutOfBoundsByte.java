package testclasses.exceptions.outofbounds.arrayload;

import it.oblive.annotations.NativeObfuscation;

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
