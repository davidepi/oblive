package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeVirtualByte {
    public ThrowInvokeVirtualByte() {

    }

    @NativeObfuscation
    public int div(int a) {
        return normalDiv(a, 0);
    }

    public byte normalDiv(int a, int b) {
        return (byte) (a / b);
    }
}