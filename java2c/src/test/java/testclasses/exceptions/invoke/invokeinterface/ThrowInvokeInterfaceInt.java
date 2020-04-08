package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeInterfaceInt {
    public ThrowInvokeInterfaceInt() {

    }

    @NativeObfuscation
    public int div(DivisionInterface interf, int a) {
        return interf.div(a);
    }
}
