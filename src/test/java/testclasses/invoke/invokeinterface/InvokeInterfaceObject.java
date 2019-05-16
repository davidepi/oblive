package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceObject {
    public InvokeInterfaceObject() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String concatenate(AdderInterface interf, String a, char b) {
        return interf.concatenate(a, b);
    }
}