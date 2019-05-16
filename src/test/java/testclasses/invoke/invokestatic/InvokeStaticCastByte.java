package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticCastByte {
    public InvokeStaticCastByte() {

    }

    public static byte normalAdd(byte a, byte b) {
        return (byte) (a + b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(byte a, byte b) {
        return normalAdd(a, b) == (byte) (a + b);
    }
}