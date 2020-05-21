package testclasses.exceptions.outofbounds.arraystore;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArrayStoreOutOfBoundsInt {
    private int[] array;

    public ThrowArrayStoreOutOfBoundsInt() {
        this.array = new int[2];
    }

    @NativeObfuscation
    public int exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
