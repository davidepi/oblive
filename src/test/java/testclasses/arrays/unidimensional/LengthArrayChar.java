package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LengthArrayChar {
    private char[] array;

    public LengthArrayChar() {
        this.array = new char[95];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getLen() {
        return this.array.length;
    }

}
