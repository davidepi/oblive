package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LoadArrayShort {
    private short[] array;

    public LoadArrayShort() {
        this.array = new short[]{1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000};
    }

    @NativeObfuscation
    public short getVal() {
        return this.array[4];
    }

}
