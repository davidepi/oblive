package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LengthArrayLong {
    private long[] array;

    public LengthArrayLong() {
        this.array = new long[93];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getLen() {
        return this.array.length;
    }

}
