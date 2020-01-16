package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeInterfaceChar {
    public InvokeInterfaceChar() {

    }

    @NativeObfuscation
    public char add(AdderInterface interf, char a, char b) {
        return interf.add(a, b);
    }
}