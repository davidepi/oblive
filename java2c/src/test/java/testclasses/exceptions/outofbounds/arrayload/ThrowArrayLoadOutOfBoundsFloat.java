package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowArrayLoadOutOfBoundsFloat {
    private float[] array;

    public ThrowArrayLoadOutOfBoundsFloat() {
        this.array = new float[2];
    }

    @NativeObfuscation
    public float exec() {
        return this.array[2];
    }
}
