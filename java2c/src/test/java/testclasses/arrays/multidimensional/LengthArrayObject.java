package testclasses.arrays.multidimensional;

import it.oblive.annotations.NativeObfuscation;

public class LengthArrayObject {
    private String[][] array;

    public LengthArrayObject() {
        this.array = new String[3][2];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
