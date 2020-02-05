package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowInvokeVirtualLong {
    public ThrowInvokeVirtualLong() {

    }

    @NativeObfuscation
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }

    public long normalDiv(int a, int b) {
        return a / b;
    }
}