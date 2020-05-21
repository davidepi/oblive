package testclasses.exceptions.negativesize.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeChar {
    private char[][][] array;

    public ThrowNegativeArraySizeChar() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new char[-1][1][1];
        return 0;
    }
}
