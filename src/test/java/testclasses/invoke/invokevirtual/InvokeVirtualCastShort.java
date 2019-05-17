package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualCastShort {
    public InvokeVirtualCastShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(short a, short b) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(a + b);
        return false;
    }

    public short normalAdd(short a, short b) {
        return (short) (a + b);
    }
}