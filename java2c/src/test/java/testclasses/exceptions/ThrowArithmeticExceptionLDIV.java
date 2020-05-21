package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArithmeticExceptionLDIV {
    public ThrowArithmeticExceptionLDIV() {

    }

    @NativeObfuscation
    public static long divide(long a) {
        return a / 0L;
    }
}
