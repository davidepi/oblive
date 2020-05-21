package testclasses.exceptions.outofbounds.arrayload;

import it.oblive.annotations.NativeObfuscation;

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
