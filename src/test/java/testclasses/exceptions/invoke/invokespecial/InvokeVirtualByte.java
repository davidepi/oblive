package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeVirtualByte {
    public InvokeVirtualByte() {

    }

    @NativeObfuscation
    public byte add(byte a, byte b) {
        return normalAdd(a, b);
    }

    public byte normalAdd(byte a, byte b) {
        int c = 1 / 0;
        return (byte) (a + b);
    }
}