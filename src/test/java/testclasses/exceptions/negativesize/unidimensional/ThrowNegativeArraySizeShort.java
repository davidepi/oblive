package testclasses.exceptions.negativesize.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowNegativeArraySizeShort {
    private short[] array;

    public ThrowNegativeArraySizeShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        this.array = new short[-1];
        return 0;
    }
}
