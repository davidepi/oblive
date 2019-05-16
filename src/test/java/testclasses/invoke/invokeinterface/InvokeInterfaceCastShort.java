package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceCastShort {
    public InvokeInterfaceCastShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(AdderInterface interf, short a, short b) {
        return interf.add(a, b) == (short) (a + b);
    }
}