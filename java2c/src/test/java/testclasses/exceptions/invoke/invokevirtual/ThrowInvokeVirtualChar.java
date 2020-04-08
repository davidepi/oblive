package testclasses.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeVirtualChar {
    public ThrowInvokeVirtualChar() {

    }

    @NativeObfuscation
    public int div(int a) {
        return normalDiv(a, 0);
    }

    public char normalDiv(int a, int b) {
        return (char) (a / b);
    }
}