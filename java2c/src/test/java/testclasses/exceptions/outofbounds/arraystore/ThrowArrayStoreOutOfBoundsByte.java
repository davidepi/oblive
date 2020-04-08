package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowArrayStoreOutOfBoundsByte {
    private byte[] array;

    public ThrowArrayStoreOutOfBoundsByte() {
        this.array = new byte[2];
    }

    @NativeObfuscation
    public byte exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
