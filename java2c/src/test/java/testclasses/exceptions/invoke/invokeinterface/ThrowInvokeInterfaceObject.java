package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeInterfaceObject {
    public ThrowInvokeInterfaceObject() {

    }

    @NativeObfuscation
    public String div(DivisionInterface interf, String a) {
        return interf.div(a);
    }
}
