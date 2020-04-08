package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeInterfaceByte {
    public ThrowInvokeInterfaceByte() {

    }

    @NativeObfuscation
    public byte div(DivisionInterface interf, byte a) {
        return interf.div(a);
    }
}
