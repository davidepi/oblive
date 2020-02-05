package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowInvokeVirtualDouble {
    public ThrowInvokeVirtualDouble() {

    }

    @NativeObfuscation
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }

    public double normalDiv(int a, int b) {
        return a / b;
    }
}