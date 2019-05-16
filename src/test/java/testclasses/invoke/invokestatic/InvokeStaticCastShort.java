package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticCastShort {
    public InvokeStaticCastShort() {

    }

    public static short normalAdd(short a, short b) {
        return (short) (a + b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(short a, short b) {
        return normalAdd(a, b) == (short) (a + b);
    }
}