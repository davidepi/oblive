package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LengthArrayChar {
    private char[] array;

    public LengthArrayChar() {
        this.array = new char[95];
    }

    @NativeObfuscation
    public int getLen() {
        return this.array.length;
    }

}
