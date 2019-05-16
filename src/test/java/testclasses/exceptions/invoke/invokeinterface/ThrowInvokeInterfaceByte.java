package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeInterfaceByte {
    public ThrowInvokeInterfaceByte() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte div(DivisionInterface interf, byte a) {
        return interf.div(a);
    }
}
