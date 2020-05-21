package testclasses.arrays.unidimensional;

import it.oblive.annotations.NativeObfuscation;

public class LengthArrayFloat {
    private float[] array;

    public LengthArrayFloat() {
        this.array = new float[84];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
