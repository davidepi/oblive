package testclasses.exceptions;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowExceptionInNew {
    public ThrowExceptionInNew() {

    }

    @NativeObfuscation
    public int exec() {
        new ClassExceptionInInit();
        return 0;
    }
}
