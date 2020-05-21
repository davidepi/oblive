package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArrayStoreException {
    private Object[] array;

    public ThrowArrayStoreException() {
        this.array = new String[2];
        this.array[0] = "hello";
        this.array[1] = "world";
    }

    @NativeObfuscation
    public Object exec() {
        this.array[1] = 1;
        return this.array[1];
    }
}
