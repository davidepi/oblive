package testclasses.exceptions;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowArithmeticExceptionLDIV {
    public ThrowArithmeticExceptionLDIV() {

    }

    @NativeObfuscation
    public static long divide(long a) {
        return a / 0L;
    }
}
