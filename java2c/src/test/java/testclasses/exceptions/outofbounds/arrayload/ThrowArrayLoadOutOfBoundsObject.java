package testclasses.exceptions.outofbounds.arrayload;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArrayLoadOutOfBoundsObject {
    private String[] array;

    public ThrowArrayLoadOutOfBoundsObject() {
        this.array = new String[2];
    }

    @NativeObfuscation
    public String exec() {
        return this.array[2];
    }
}
