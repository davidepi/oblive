package testclasses.exceptions.negativesize.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeFloat {
    private float[][][] array;

    public ThrowNegativeArraySizeFloat() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new float[-1][1][1];
        return 0;
    }
}
