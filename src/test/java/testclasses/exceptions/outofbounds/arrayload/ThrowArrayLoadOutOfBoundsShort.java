package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayLoadOutOfBoundsShort {
    private short[] array;

    public ThrowArrayLoadOutOfBoundsShort() {
        this.array = new short[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short exec() {
        return this.array[2];
    }
}
