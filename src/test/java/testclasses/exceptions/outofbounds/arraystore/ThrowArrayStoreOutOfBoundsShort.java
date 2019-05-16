package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayStoreOutOfBoundsShort {
    private short[] array;

    public ThrowArrayStoreOutOfBoundsShort() {
        this.array = new short[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
