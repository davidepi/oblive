package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeVirtualCastBoolean {
    public InvokeVirtualCastBoolean() {

    }

    @NativeObfuscation
    public boolean and(boolean a, boolean b) {
        return normalAnd(a, b) == a && b;
    }

    public boolean normalAnd(boolean a, boolean b) {
        return a && b;
    }
}