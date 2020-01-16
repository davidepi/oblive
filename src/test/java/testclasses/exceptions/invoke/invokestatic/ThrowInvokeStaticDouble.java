package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowInvokeStaticDouble {
    public ThrowInvokeStaticDouble() {

    }

    public static double normalDiv(int a, int b) {
        return (double) (a / b);
    }

    @NativeObfuscation
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }
}
