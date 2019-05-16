package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticBoolean {
    public InvokeStaticBoolean() {

    }

    public static boolean normalAnd(boolean a, boolean b) {
        return a && b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean and(boolean a, boolean b) {
        return normalAnd(a, b);
    }
}