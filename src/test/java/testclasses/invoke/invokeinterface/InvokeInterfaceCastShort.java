package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeInterfaceCastShort {
    public InvokeInterfaceCastShort() {

    }

    @NativeObfuscation
    public boolean add(AdderInterface interf, short a, short b) {
        return interf.add(a, b) == (short) (a + b);
    }
}