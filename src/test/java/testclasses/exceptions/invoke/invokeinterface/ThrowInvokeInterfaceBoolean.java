package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeInterfaceBoolean {
    public ThrowInvokeInterfaceBoolean() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean div(DivisionInterface interf, boolean a) {
        return interf.div(a);
    }
}
