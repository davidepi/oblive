package testclasses.exceptions;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowClassCastException {
    public ThrowClassCastException() {

    }

    @NativeObfuscation
    public static String castString(Object a) {
        return (String) a;
    }
}
