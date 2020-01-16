package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LengthArrayShort {
    private short[] array;

    public LengthArrayShort() {
        this.array = new short[85];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
