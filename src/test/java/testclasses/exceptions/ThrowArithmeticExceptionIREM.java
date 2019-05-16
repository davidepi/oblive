package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowArithmeticExceptionIREM {
    public ThrowArithmeticExceptionIREM() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int mod(int a) {
        return a % 0;
    }
}
