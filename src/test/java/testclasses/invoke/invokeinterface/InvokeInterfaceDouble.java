package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeInterfaceDouble {
    public InvokeInterfaceDouble() {

    }

    @NativeObfuscation
    public double add(AdderInterface interf, double a, double b) {
        return interf.add(a, b);
    }
}