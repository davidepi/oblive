package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowInvokeInterfaceFloat {
    public ThrowInvokeInterfaceFloat() {

    }

    @NativeObfuscation
    public float div(DivisionInterface interf, float a) {
        return interf.div(a);
    }
}
