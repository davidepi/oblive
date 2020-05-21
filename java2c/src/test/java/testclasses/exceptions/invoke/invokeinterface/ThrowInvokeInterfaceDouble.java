package testclasses.exceptions.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class ThrowInvokeInterfaceDouble {
    public ThrowInvokeInterfaceDouble() {

    }

    @NativeObfuscation
    public double div(DivisionInterface interf, double a) {
        return interf.div(a);
    }
}
