package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ThrowInvokeInterfaceDouble {
    public ThrowInvokeInterfaceDouble() {

    }

    @NativeObfuscation
    public double div(DivisionInterface interf, double a) {
        return interf.div(a);
    }
}
