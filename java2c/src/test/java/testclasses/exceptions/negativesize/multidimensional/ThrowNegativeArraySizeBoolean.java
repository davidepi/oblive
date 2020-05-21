package testclasses.exceptions.negativesize.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeBoolean {
    private boolean[][][] array;

    public ThrowNegativeArraySizeBoolean() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new boolean[-1][1][1];
        return 0;
    }
}
