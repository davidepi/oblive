package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowArrayStoreOutOfBoundsLong {
    private long[] array;

    public ThrowArrayStoreOutOfBoundsLong() {
        this.array = new long[2];
    }

    @NativeObfuscation
    public long exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
