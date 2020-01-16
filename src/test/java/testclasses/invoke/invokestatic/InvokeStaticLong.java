package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeStaticLong {
    public InvokeStaticLong() {

    }

    public static long normalAdd(long a, long b) {
        return a + b;
    }

    @NativeObfuscation
    public long add(long a, long b) {
        return normalAdd(a, b);
    }
}