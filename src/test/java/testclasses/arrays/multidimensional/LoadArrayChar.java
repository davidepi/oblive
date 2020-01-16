package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LoadArrayChar {
    private char[][] array;

    public LoadArrayChar() {
        this.array = new char[2][5];
        this.array[0] = new char[]{'a', 'e', 'i', 'o', 'u'};
        this.array[1] = new char[]{'あ', 'え', 'い', 'お', 'う'};
    }

    @NativeObfuscation
    public char getVal() {
        return this.array[1][3];
    }

}
