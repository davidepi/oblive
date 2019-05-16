package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualShort {
    public InvokeVirtualShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short add(short a, short b) {
        return normalAdd(a, b);
    }

    public short normalAdd(short a, short b) {
        int c = 1 / 0;
        return (short) (a + b);
    }
}