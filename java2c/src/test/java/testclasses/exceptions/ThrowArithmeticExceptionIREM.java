package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArithmeticExceptionIREM {
    public ThrowArithmeticExceptionIREM() {

    }

    @NativeObfuscation
    public static int mod(int a) {
        return a % 0;
    }
}
