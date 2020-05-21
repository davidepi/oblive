package testclasses.exceptions.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeStaticChar {
    public ThrowInvokeStaticChar() {

    }

    public static char normalDiv(int a, int b) {
        return (char) (a / b);
    }

    @NativeObfuscation
    public int div(int a) {
        return normalDiv(a, 0);
    }
}
