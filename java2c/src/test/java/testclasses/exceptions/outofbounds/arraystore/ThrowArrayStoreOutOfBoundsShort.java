package testclasses.exceptions.outofbounds.arraystore;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArrayStoreOutOfBoundsShort {
    private short[] array;

    public ThrowArrayStoreOutOfBoundsShort() {
        this.array = new short[2];
    }

    @NativeObfuscation
    public short exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
