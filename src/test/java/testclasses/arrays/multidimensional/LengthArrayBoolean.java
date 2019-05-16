package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LengthArrayBoolean {
    private boolean[][] array;

    public LengthArrayBoolean() {
        this.array = new boolean[3][2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getLen() {
        return this.array.length;
    }

}
