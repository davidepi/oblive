package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LengthArrayLong {
    private long[] array;

    public LengthArrayLong() {
        this.array = new long[93];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
