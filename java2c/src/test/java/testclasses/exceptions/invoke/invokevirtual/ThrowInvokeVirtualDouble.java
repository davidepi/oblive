package testclasses.exceptions.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeVirtualDouble {
    public ThrowInvokeVirtualDouble() {

    }

    @NativeObfuscation
    public int div(int a) {
        return (int) normalDiv(a, 0);
    }

    public double normalDiv(int a, int b) {
        return a / b;
    }
}