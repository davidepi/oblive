package testclasses.exceptions.outofbounds.arraystore;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowArrayStoreOutOfBoundsFloat {
    private float[] array;

    public ThrowArrayStoreOutOfBoundsFloat() {
        this.array = new float[2];
    }

    @NativeObfuscation
    public float exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
