package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LengthArrayBoolean {
    private boolean[] array;

    public LengthArrayBoolean() {
        this.array = new boolean[61];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
