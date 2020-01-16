package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LoadArrayByte {
    private byte[][] array;

    public LoadArrayByte() {
        this.array = new byte[2][3];
        this.array[0] = new byte[]{100, 101, 102};
        this.array[1] = new byte[]{103, 104, 105};
    }

    @NativeObfuscation
    public byte getVal() {
        return this.array[1][2];
    }

}
