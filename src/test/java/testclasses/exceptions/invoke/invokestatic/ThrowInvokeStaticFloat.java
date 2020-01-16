package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowInvokeStaticFloat {
    public ThrowInvokeStaticFloat() {

    }

    public static float normalDiv(int a, int b) {
        return (float) (a / b);
    }

    @NativeObfuscation
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }
}
