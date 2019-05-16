package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LengthArrayBoolean {
    private boolean[] array;

    public LengthArrayBoolean() {
        this.array = new boolean[61];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getLen() {
        return this.array.length;
    }

}
