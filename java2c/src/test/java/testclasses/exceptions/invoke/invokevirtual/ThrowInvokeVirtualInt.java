package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeVirtualInt {
    public ThrowInvokeVirtualInt() {

    }

    @NativeObfuscation
    public int div(int a) {
        return normalDiv(a, 0);
    }

    public int normalDiv(int a, int b) {
        return a / b;
    }
}