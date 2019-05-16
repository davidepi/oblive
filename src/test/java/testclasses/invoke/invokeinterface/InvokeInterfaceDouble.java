package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceDouble {
    public InvokeInterfaceDouble() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double add(AdderInterface interf, double a, double b) {
        return interf.add(a, b);
    }
}