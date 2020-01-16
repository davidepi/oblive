package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeVirtualShort {
    public InvokeVirtualShort() {

    }

    @NativeObfuscation
    public short add(short a, short b) {
        return normalAdd(a, b);
    }

    public short normalAdd(short a, short b) {
        return (short) (a + b);
    }
}