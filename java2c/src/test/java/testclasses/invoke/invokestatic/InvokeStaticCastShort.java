package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeStaticCastShort {
    public InvokeStaticCastShort() {

    }

    public static short normalAdd(short a, short b) {
        return (short) (a + b);
    }

    @NativeObfuscation
    public boolean add(short a, short b) {
        return normalAdd(a, b) == (short) (a + b);
    }
}