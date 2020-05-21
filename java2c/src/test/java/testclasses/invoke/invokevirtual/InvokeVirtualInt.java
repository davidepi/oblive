package testclasses.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

public class InvokeVirtualInt {
    public InvokeVirtualInt() {

    }

    @NativeObfuscation
    public int add(int a, int b) {
        return normalAdd(a, b);
    }

    public int normalAdd(int a, int b) {
        return a + b;
    }
}