package testclasses.exceptions;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowArithmeticExceptionIREM {
    public ThrowArithmeticExceptionIREM() {

    }

    @NativeObfuscation
    public static int mod(int a) {
        return a % 0;
    }
}
