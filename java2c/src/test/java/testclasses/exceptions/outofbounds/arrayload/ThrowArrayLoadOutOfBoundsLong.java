package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowArrayLoadOutOfBoundsLong {
    private long[] array;

    public ThrowArrayLoadOutOfBoundsLong() {
        this.array = new long[2];
    }

    @NativeObfuscation
    public long exec() {
        return this.array[2];
    }
}
