package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeInterfaceFloat {
    public ThrowInvokeInterfaceFloat() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float div(DivisionInterface interf, float a) {
        return interf.div(a);
    }
}
