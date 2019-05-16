package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeStaticDouble {
    public ThrowInvokeStaticDouble() {

    }

    public static double normalDiv(int a, int b) {
        return (double) (a / b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }
}
