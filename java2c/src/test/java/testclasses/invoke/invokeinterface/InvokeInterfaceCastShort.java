package testclasses.invoke.invokeinterface;

import it.oblive.annotations.NativeObfuscation;

public class InvokeInterfaceCastShort {
    public InvokeInterfaceCastShort() {

    }

    @NativeObfuscation
    public boolean add(AdderInterface interf, short a, short b) {
        return interf.add(a, b) == (short) (a + b);
    }
}