package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LoadArrayChar {
    private char[] array;

    public LoadArrayChar() {
        this.array = new char[]{'a', 'b', 'c', 'd', '光', 'e', 'f', 'g'};
    }

    @NativeObfuscation
    public char getVal() {
        return this.array[4];
    }

}
