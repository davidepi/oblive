package testclasses.exceptions;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowExceptionInNew {
    public ThrowExceptionInNew() {

    }

    @NativeObfuscation
    public int exec() {
        new ClassExceptionInInit();
        return 0;
    }
}
