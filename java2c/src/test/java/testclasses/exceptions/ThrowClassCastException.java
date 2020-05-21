package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class ThrowClassCastException {
    public ThrowClassCastException() {

    }

    @NativeObfuscation
    public static String castString(Object a) {
        return (String) a;
    }
}
