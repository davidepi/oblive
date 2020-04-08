package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeInt {
    private int[][][] array;

    public ThrowNegativeArraySizeInt() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new int[-1][1][1];
        return 0;
    }
}
