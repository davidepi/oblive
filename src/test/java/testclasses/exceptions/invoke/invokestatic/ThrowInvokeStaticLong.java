package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeStaticLong {
    public ThrowInvokeStaticLong() {

    }

    public static long normalDiv(int a, int b) {
        return (long) (a / b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }
}
