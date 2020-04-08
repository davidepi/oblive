package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeLong {
    private long[] array;

    public ThrowNegativeArraySizeLong() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new long[-1];
        return 0;
    }
}
