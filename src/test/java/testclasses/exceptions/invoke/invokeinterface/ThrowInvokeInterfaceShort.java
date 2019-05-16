package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeInterfaceShort {
    public ThrowInvokeInterfaceShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short div(DivisionInterface interf, short a) {
        return interf.div(a);
    }
}
