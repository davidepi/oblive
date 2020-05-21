package testclasses.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

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