package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArithmeticExceptionLREM {
    public ThrowArithmeticExceptionLREM() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static long mod(long a) {
        return a % 0L;
    }
}
