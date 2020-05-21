package testclasses.exceptions;

import it.oblive.annotations.NativeObfuscation;

public class ThrowArithmeticExceptionIDIV {
    public ThrowArithmeticExceptionIDIV() {

    }

    @NativeObfuscation
    public static int divide(int a) {
        return a / 0;
    }
}
