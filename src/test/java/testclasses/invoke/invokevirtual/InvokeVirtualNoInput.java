package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualNoInput {
    public InvokeVirtualNoInput() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(int a, int b) {
        return alwaysTrue();
    }

    public boolean alwaysTrue() {
        return true;
    }
}