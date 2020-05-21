package testclasses.exceptions.outofbounds.arraystore;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArrayStoreOutOfBoundsChar {
    private char[] array;

    public ThrowArrayStoreOutOfBoundsChar() {
        this.array = new char[2];
    }

    @NativeObfuscation
    public char exec() {
        this.array[2] = 1;
        return this.array[2];
    }
}
