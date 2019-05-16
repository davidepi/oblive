package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeStaticInt {
    public ThrowInvokeStaticInt() {

    }

    public static int normalDiv(int a, int b) {
        return a / b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return normalDiv(a, 0);
    }
}
