package testclasses.exceptions.invoke.invokespecial;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeSpecialByte extends InvokeVirtualByte {
    public ThrowInvokeSpecialByte() {

    }

    @NativeObfuscation
    @Override
    public byte add(byte a, byte b) {
        return super.normalAdd(a, b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public byte normalAdd(byte a, byte b) {
        return (byte) (a - b);
    }
}
