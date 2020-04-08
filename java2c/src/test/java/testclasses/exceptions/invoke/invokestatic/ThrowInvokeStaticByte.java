package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeStaticByte {
    public ThrowInvokeStaticByte() {

    }

    public static byte normalDiv(int a, int b) {
        return (byte) (a / b);
    }

    @NativeObfuscation
    public int div(int a) {
        return normalDiv(a, 0);
    }
}
