package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeVirtualChar {
    public ThrowInvokeVirtualChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }

    public char normalDiv(int a, int b) {
        return (char) (a / b);
    }
}