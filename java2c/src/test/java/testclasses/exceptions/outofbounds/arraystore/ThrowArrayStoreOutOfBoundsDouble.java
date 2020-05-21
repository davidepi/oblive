package testclasses.exceptions.outofbounds.arraystore;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArrayStoreOutOfBoundsDouble {
    private double[] array;

    public ThrowArrayStoreOutOfBoundsDouble() {
        this.array = new double[2];
    }

    @NativeObfuscation
    public double exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
