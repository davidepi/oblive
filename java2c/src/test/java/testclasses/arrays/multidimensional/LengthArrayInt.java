package testclasses.arrays.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class LengthArrayInt {
    private int[][] array;

    public LengthArrayInt() {
        this.array = new int[3][2];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
