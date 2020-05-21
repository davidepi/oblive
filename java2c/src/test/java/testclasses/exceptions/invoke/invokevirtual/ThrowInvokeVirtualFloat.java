package testclasses.exceptions.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

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