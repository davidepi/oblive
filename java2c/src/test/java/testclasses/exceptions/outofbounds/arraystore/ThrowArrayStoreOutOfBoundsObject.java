package testclasses.exceptions.outofbounds.arraystore;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArrayStoreOutOfBoundsObject {
    private String[] array;

    public ThrowArrayStoreOutOfBoundsObject() {
        this.array = new String[2];
    }

    @NativeObfuscation
    public String exec() {
        this.array[2] = "string0";
        return this.array[2];
    }
}
