package testclasses.exceptions.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeVirtualBoolean {
    public ThrowInvokeVirtualBoolean() {

    }

    @NativeObfuscation
    public int div(int a) {
        return normalDiv(a, 0) ? 0 : -1;
    }

    public boolean normalDiv(int a, int b) {
        return (a / b) > 0;
    }
}