package testclasses.arrays.unidimensional;

import it.oblive.annotations.NativeObfuscation;

public class LengthArrayByte {
    private byte[] array;

    public LengthArrayByte() {
        this.array = new byte[84];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
