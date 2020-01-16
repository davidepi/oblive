package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeInterfaceInt {
    public InvokeInterfaceInt() {

    }

    @NativeObfuscation
    public int add(AdderInterface interf, int a, int b) {
        return interf.add(a, b);
    }
}