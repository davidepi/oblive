package testclasses.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class InvokeStaticShort {
    public InvokeStaticShort() {

    }

    public static short normalAdd(short a, short b) {
        return (short) (a + b);
    }

    @NativeObfuscation
    public short add(short a, short b) {
        return normalAdd(a, b);
    }
}