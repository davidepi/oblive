package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowNegativeArraySizeByte {
    private byte[][][] array;

    public ThrowNegativeArraySizeByte() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new byte[-1][1][1];
        return 0;
    }
}
