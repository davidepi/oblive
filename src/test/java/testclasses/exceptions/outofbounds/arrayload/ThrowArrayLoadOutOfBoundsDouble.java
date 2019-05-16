package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArrayLoadOutOfBoundsDouble {
    private double[] array;

    public ThrowArrayLoadOutOfBoundsDouble() {
        this.array = new double[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec() {
        return this.array[2];
    }
}
