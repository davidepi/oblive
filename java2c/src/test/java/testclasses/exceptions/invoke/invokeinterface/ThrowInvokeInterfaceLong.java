package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeInterfaceLong {
    public ThrowInvokeInterfaceLong() {

    }

    @NativeObfuscation
    public long div(DivisionInterface interf, long a) {
        return interf.div(a);
    }
}
