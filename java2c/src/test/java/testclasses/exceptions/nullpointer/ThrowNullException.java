package testclasses.exceptions.nullpointer;

import it.oblive.annotations.NativeObfuscation;

public class ThrowNullException {
    public ThrowNullException() {

    }

    @NativeObfuscation
    public int exec() {
        throw null;
    }
}
