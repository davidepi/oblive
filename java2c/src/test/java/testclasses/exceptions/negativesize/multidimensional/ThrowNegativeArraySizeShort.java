package testclasses.exceptions.negativesize.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeShort {
    private short[][][] array;

    public ThrowNegativeArraySizeShort() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new short[-1][1][1];
        return 0;
    }
}
