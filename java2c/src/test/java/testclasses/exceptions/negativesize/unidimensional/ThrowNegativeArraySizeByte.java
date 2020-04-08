package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeByte {
    private byte[] array;

    public ThrowNegativeArraySizeByte() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new byte[-1];
        return 0;
    }
}
