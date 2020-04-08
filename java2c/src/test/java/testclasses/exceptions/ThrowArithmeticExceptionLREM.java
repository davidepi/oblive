package testclasses.exceptions;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowArithmeticExceptionLREM {
    public ThrowArithmeticExceptionLREM() {

    }

    @NativeObfuscation
    public static long mod(long a) {
        return a % 0L;
    }
}
