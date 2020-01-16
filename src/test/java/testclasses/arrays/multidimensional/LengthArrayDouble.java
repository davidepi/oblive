package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LengthArrayDouble {
    private double[][] array;

    public LengthArrayDouble() {
        this.array = new double[3][2];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
