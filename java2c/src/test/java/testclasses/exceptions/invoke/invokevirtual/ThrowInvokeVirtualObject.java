package testclasses.exceptions.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeVirtualObject {
    public ThrowInvokeVirtualObject() {

    }

    @NativeObfuscation
    public int div(int a) {
        return ((Integer) normalDiv(a, 0));
    }

    public Object normalDiv(int a, int b) {
        return a / b;
    }
}