package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class ThrowInvokeInterfaceChar {
    public ThrowInvokeInterfaceChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char div(DivisionInterface interf, char a) {
        return interf.div(a);
    }
}
