package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeInterfaceDouble {
    public InvokeInterfaceDouble() {

    }

    @NativeObfuscation
    public double add(AdderInterface interf, double a, double b) {
        return interf.add(a, b);
    }
}