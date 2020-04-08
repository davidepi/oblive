package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeInterfaceChar {
    public ThrowInvokeInterfaceChar() {

    }

    @NativeObfuscation
    public char div(DivisionInterface interf, char a) {
        return interf.div(a);
    }
}
