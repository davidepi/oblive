package testclasses.exceptions.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeStaticObject {
    public ThrowInvokeStaticObject() {

    }

    public static Object normalDiv(int a, int b) {
        return a / b;
    }

    @NativeObfuscation
    public int div(int a) {
        return ((Integer) normalDiv(a, 0));
    }
}
