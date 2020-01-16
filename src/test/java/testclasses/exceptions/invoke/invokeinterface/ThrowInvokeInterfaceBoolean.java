package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowInvokeInterfaceBoolean {
    public ThrowInvokeInterfaceBoolean() {

    }

    @NativeObfuscation
    public boolean div(DivisionInterface interf, boolean a) {
        return interf.div(a);
    }
}
