package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowInvokeVirtualFloat {
    public ThrowInvokeVirtualFloat() {

    }

    @NativeObfuscation
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }

    public float normalDiv(int a, int b) {
        return (float) (a / b);
    }
}