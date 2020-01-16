package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeInterfaceCastBoolean {
    public InvokeInterfaceCastBoolean() {

    }

    @NativeObfuscation
    public boolean and(AdderInterface interf, boolean a, boolean b) {
        return interf.and(a, b) == a && b;
    }
}