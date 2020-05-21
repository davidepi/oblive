package testclasses.arrays.unidimensional;

import it.oblive.annotations.NativeObfuscation;

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
