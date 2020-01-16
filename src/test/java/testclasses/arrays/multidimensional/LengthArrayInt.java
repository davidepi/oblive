package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

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
