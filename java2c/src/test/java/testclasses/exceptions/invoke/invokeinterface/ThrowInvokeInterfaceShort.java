package testclasses.exceptions.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeInterfaceShort {
    public ThrowInvokeInterfaceShort() {

    }

    @NativeObfuscation
    public short div(DivisionInterface interf, short a) {
        return interf.div(a);
    }
}
