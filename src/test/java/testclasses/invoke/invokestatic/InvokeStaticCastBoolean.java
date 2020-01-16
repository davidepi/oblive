package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeStaticCastBoolean {
    public InvokeStaticCastBoolean() {

    }

    public static boolean normalAnd(boolean a, boolean b) {
        return a && b;
    }

    @NativeObfuscation
    public boolean and(boolean a, boolean b) {
        return normalAnd(a, b) == a && b;
    }
}