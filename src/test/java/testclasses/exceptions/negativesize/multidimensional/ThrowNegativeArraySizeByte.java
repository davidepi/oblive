package testclasses.exceptions.negativesize.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowNegativeArraySizeByte {
    private byte[][][] array;

    public ThrowNegativeArraySizeByte() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        this.array = new byte[-1][1][1];
        return 0;
    }
}
