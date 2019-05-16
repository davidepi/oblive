package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArithmeticExceptionIDIV {
    public ThrowArithmeticExceptionIDIV() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int divide(int a) {
        return a / 0;
    }
}
