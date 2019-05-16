package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualBoolean {
    public InvokeVirtualBoolean() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean and(boolean a, boolean b) {
        return normalAnd(a, b);
    }

    public boolean normalAnd(boolean a, boolean b) {
        return a && b;
    }
}