package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualFloat {
    public InvokeVirtualFloat() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float add(float a, float b) {
        return normalAdd(a, b);
    }

    public float normalAdd(float a, float b) {
        int c = 1 / 0;
        return a + b;
    }
}