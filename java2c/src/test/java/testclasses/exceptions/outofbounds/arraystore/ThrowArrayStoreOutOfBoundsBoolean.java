package testclasses.exceptions.outofbounds.arraystore;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArrayStoreOutOfBoundsBoolean {
    private boolean[] array;

    public ThrowArrayStoreOutOfBoundsBoolean() {
        this.array = new boolean[2];
    }

    @NativeObfuscation
    public boolean exec() {
        this.array[2] = true;
        return this.array[2];
    }
}
