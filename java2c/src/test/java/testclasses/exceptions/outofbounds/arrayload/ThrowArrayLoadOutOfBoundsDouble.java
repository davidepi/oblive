package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowArrayLoadOutOfBoundsDouble {
    private double[] array;

    public ThrowArrayLoadOutOfBoundsDouble() {
        this.array = new double[2];
    }

    @NativeObfuscation
    public double exec() {
        return this.array[2];
    }
}
