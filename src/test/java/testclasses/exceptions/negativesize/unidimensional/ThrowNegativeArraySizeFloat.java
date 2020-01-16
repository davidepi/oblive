package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowNegativeArraySizeFloat {
    private float[] array;

    public ThrowNegativeArraySizeFloat() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new float[-1];
        return 0;
    }
}
