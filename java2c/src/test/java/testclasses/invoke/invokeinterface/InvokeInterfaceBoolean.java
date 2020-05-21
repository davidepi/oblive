package testclasses.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class InvokeInterfaceBoolean {
    public InvokeInterfaceBoolean() {

    }

    @NativeObfuscation
    public boolean and(AdderInterface interf, boolean a, boolean b) {
        return interf.and(a, b);
    }
}