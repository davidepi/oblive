package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class ThrowUserDefinedException {
    public ThrowUserDefinedException() {

    }

    @NativeObfuscation
    public int exec() throws UserDefinedException {
        throw new UserDefinedException();
    }
}
