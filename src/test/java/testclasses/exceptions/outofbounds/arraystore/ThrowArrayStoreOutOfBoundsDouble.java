package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayStoreOutOfBoundsDouble {
    private double[] array;

    public ThrowArrayStoreOutOfBoundsDouble() {
        this.array = new double[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
