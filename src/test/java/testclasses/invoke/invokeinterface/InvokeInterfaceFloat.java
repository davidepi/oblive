package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeInterfaceFloat {
    public InvokeInterfaceFloat() {

    }

    @NativeObfuscation
    public float add(AdderInterface interf, float a, float b) {
        return interf.add(a, b);
    }
}