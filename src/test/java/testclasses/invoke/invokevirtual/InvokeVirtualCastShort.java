package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeVirtualCastShort {
    public InvokeVirtualCastShort() {

    }

    @NativeObfuscation
    public boolean add(short a, short b) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(a + b);
        return false;
    }

    public short normalAdd(short a, short b) {
        return (short) (a + b);
    }
}