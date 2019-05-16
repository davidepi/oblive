package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayStoreOutOfBoundsInt {
    private int[] array;

    public ThrowArrayStoreOutOfBoundsInt() {
        this.array = new int[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
