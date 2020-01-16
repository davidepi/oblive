package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LengthArrayObject {
    private String[] array;

    public LengthArrayObject() {
        this.array = new String[3];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
