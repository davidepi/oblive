package testclasses.arrays.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class LengthArrayLong {
    private long[][] array;

    public LengthArrayLong() {
        this.array = new long[3][2];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
