package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LengthArrayFloat {
    private float[][] array;

    public LengthArrayFloat() {
        this.array = new float[3][2];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
