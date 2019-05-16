package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeStaticShort {
    public ThrowInvokeStaticShort() {

    }

    public static short normalDiv(int a, int b) {
        return (short) (a / b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }
}
