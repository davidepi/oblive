package testclasses.exceptions;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowArithmeticExceptionIDIV {
    public ThrowArithmeticExceptionIDIV() {

    }

    @NativeObfuscation
    public static int divide(int a) {
        return a / 0;
    }
}
