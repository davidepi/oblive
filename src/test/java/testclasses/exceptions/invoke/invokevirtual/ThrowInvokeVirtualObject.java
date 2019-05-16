package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeVirtualObject {
    public ThrowInvokeVirtualObject() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return ((Integer) normalDiv(a, 0));
    }

    public Object normalDiv(int a, int b) {
        return a / b;
    }
}