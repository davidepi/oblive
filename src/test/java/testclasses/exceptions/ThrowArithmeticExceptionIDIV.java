package testclasses.exceptions;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowArithmeticExceptionIDIV {
    public ThrowArithmeticExceptionIDIV() {

    }

    @NativeObfuscation
    public static int divide(int a) {
        return a / 0;
    }
}
