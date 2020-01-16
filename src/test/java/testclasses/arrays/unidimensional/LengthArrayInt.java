package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LengthArrayInt {
    private int[] array;

    public LengthArrayInt() {
        this.array = new int[87];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
