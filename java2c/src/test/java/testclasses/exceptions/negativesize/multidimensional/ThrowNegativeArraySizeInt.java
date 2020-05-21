package testclasses.exceptions.negativesize.multidimensional;

import it.oblive.annotations.NativeObfuscation;

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
