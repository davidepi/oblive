package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayStoreOutOfBoundsLong {
    private long[] array;

    public ThrowArrayStoreOutOfBoundsLong() {
        this.array = new long[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
