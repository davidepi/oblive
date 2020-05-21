package testclasses.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class InvokeInterfaceShort {
    public InvokeInterfaceShort() {

    }

    @NativeObfuscation
    public short add(AdderInterface interf, short a, short b) {
        return interf.add(a, b);
    }
}