package testclasses.exceptions.negativesize.unidimensional;

import it.oblive.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeShort {
    private short[] array;

    public ThrowNegativeArraySizeShort() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new short[-1];
        return 0;
    }
}
