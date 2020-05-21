package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class ThrowExceptionInNew {
    public ThrowExceptionInNew() {

    }

    @NativeObfuscation
    public int exec() {
        new ClassExceptionInInit();
        return 0;
    }
}
