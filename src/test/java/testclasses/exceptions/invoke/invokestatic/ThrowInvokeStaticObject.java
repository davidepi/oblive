package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeStaticObject {
    public ThrowInvokeStaticObject() {

    }

    public static Object normalDiv(int a, int b) {
        return a / b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return ((Integer) normalDiv(a, 0));
    }
}
