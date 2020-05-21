package testclasses.exceptions.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeStaticInt {
    public ThrowInvokeStaticInt() {

    }

    public static int normalDiv(int a, int b) {
        return a / b;
    }

    @NativeObfuscation
    public int div(int a) {
        return normalDiv(a, 0);
    }
}
