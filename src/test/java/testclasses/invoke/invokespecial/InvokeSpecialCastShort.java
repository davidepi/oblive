package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeSpecialCastShort extends InvokeVirtualCastShort {
    public InvokeSpecialCastShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    @Override
    public boolean add(short a, short b) {
        return super.normalAdd(a, b) == (short) (a + b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public short normalAdd(short a, short b) {
        return (short) (a - b);
    }
}