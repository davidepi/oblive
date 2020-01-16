package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeInterfaceCastChar {
    public InvokeInterfaceCastChar() {

    }

    @NativeObfuscation
    public boolean add(AdderInterface interf, char a, char b) {
        return interf.add(a, b) == (char) (a + b);
    }
}