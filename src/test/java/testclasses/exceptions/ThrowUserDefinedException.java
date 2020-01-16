package testclasses.exceptions;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowUserDefinedException {
    public ThrowUserDefinedException() {

    }

    @NativeObfuscation
    public int exec() throws UserDefinedException {
        throw new UserDefinedException();
    }
}
