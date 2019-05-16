package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualCastShort {
    public InvokeVirtualCastShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(short a, short b) {
        return normalAdd(a, b) == (short) (a + b);
    }

    public short normalAdd(short a, short b) {
        return (short) (a + b);
    }
}