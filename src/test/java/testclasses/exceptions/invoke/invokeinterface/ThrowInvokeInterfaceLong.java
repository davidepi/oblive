package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeInterfaceLong {
    public ThrowInvokeInterfaceLong() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long div(DivisionInterface interf, long a) {
        return interf.div(a);
    }
}
