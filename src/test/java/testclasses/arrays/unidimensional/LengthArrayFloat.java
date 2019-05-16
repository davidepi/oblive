package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LengthArrayFloat {
    private float[] array;

    public LengthArrayFloat() {
        this.array = new float[84];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getLen() {
        return this.array.length;
    }

}
