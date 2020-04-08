package testclasses.exceptions;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowUserDefinedException {
    public ThrowUserDefinedException() {

    }

    @NativeObfuscation
    public int exec() throws UserDefinedException {
        throw new UserDefinedException();
    }
}
