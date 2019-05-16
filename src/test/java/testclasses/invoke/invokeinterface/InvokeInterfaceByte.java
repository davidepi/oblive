package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceByte {
    public InvokeInterfaceByte() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte add(AdderInterface interf, byte a, byte b) {
        return interf.add(a, b);
    }
}