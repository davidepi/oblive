package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeStaticFloat {
    public ThrowInvokeStaticFloat() {

    }

    public static float normalDiv(int a, int b) {
        return (float) (a / b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }
}
