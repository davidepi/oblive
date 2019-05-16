package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArithmeticExceptionLDIV {
    public ThrowArithmeticExceptionLDIV() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static long divide(long a) {
        return a / 0L;
    }
}
