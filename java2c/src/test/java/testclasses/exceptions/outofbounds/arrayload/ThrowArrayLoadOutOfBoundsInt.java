package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowArrayLoadOutOfBoundsInt {
    private int[] array;

    public ThrowArrayLoadOutOfBoundsInt() {
        this.array = new int[2];
    }

    @NativeObfuscation
    public int exec() {
        return this.array[2];
    }
}
