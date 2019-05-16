package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceShort {
    public InvokeInterfaceShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short add(AdderInterface interf, short a, short b) {
        return interf.add(a, b);
    }
}