package testclasses.exceptions.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeStaticShort {
    public ThrowInvokeStaticShort() {

    }

    public static short normalDiv(int a, int b) {
        return (short) (a / b);
    }

    @NativeObfuscation
    public int div(int a) {
        return normalDiv(a, 0);
    }
}
