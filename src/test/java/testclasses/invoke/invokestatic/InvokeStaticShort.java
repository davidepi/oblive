package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticShort {
    public InvokeStaticShort() {

    }

    public static short normalAdd(short a, short b) {
        return (short) (a + b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short add(short a, short b) {
        return normalAdd(a, b);
    }
}