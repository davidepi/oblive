package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArithmeticExceptionLREM {
    public ThrowArithmeticExceptionLREM() {

    }

    @NativeObfuscation
    public static long mod(long a) {
        return a % 0L;
    }
}
