package testclasses.arrays.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class LengthArrayByte {
    private byte[][] array;

    public LengthArrayByte() {
        this.array = new byte[3][2];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
