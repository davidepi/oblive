package testclasses.exceptions.outofbounds.arrayload;

import it.oblive.annotations.NativeObfuscation;

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
