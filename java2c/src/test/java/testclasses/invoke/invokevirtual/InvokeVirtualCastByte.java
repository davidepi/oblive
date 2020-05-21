package testclasses.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

public class InvokeVirtualCastByte {
    public InvokeVirtualCastByte() {

    }

    @NativeObfuscation
    public boolean add(byte a, byte b) {
        return normalAdd(a, b) == (byte) (a + b);
    }

    public byte normalAdd(byte a, byte b) {
        return (byte) (a + b);
    }
}