package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeVirtualByte {
    public InvokeVirtualByte() {

    }

    @NativeObfuscation
    public byte add(byte a, byte b) {
        return normalAdd(a, b);
    }

    public byte normalAdd(byte a, byte b) {
        return (byte) (a + b);
    }
}