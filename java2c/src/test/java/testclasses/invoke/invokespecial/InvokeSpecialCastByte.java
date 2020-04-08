package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeSpecialCastByte extends InvokeVirtualCastByte {
    public InvokeSpecialCastByte() {

    }

    @NativeObfuscation
    @Override
    public boolean add(byte a, byte b) {
        return super.normalAdd(a, b) == (byte) (a + b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public byte normalAdd(byte a, byte b) {
        return (byte) (a - b);
    }
}