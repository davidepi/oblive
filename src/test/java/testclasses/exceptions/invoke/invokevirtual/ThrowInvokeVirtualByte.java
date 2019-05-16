package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeVirtualByte {
    public ThrowInvokeVirtualByte() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a) {
        return normalDiv(a, 0);
    }

    public byte normalDiv(int a, int b) {
        return (byte) (a / b);
    }
}