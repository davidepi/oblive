package testclasses.exceptions.nullpointer;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowNullException {
    public ThrowNullException() {

    }

    @NativeObfuscation
    public int exec() {
        throw null;
    }
}
