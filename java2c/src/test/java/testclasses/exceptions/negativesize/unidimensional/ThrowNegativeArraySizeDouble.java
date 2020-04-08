package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeDouble {
    private double[] array;

    public ThrowNegativeArraySizeDouble() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new double[-1];
        return 0;
    }
}
