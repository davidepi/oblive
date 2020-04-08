package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LengthArrayBoolean {
    private boolean[][] array;

    public LengthArrayBoolean() {
        this.array = new boolean[3][2];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
