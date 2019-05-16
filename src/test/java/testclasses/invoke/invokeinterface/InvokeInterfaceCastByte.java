package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceCastByte {
    public InvokeInterfaceCastByte() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(AdderInterface interf, byte a, byte b) {
        return interf.add(a, b) == a + b;
    }
}