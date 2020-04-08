package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeStaticCastChar {
    public InvokeStaticCastChar() {

    }

    public static char normalAdd(char a, char b) {
        return (char) (a + b);
    }

    @NativeObfuscation
    public boolean add(char a, char b) {
        return normalAdd(a, b) == (char) (a + b);
    }
}