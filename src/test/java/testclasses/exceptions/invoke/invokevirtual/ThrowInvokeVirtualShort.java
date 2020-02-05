package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowInvokeVirtualShort {
    public ThrowInvokeVirtualShort() {

    }

    @NativeObfuscation
    public int div(int a) {
        return normalDiv(a, 0);
    }

    public short normalDiv(int a, int b) {
        return (short) (a / b);
    }
}