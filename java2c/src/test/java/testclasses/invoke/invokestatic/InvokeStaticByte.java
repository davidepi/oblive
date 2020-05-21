package testclasses.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class InvokeStaticByte {
    public InvokeStaticByte() {

    }

    public static byte normalAdd(byte a, byte b) {
        return (byte) (a + b);
    }

    @NativeObfuscation
    public byte add(byte a, byte b) {
        return normalAdd(a, b);
    }
}