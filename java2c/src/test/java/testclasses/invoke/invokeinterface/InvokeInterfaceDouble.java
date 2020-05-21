package testclasses.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class InvokeInterfaceDouble {
    public InvokeInterfaceDouble() {

    }

    @NativeObfuscation
    public double add(AdderInterface interf, double a, double b) {
        return interf.add(a, b);
    }
}