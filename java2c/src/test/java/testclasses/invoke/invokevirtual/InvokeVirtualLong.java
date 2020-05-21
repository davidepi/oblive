package testclasses.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

public class InvokeVirtualLong {
    public InvokeVirtualLong() {

    }

    @NativeObfuscation
    public long add(long a, long b) {
        return normalAdd(a, b);
    }

    public long normalAdd(long a, long b) {
        return a + b;
    }
}