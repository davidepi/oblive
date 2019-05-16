package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeInterfaceInt {
    public InvokeInterfaceInt() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int add(AdderInterface interf, int a, int b) {
        return interf.add(a, b);
    }
}