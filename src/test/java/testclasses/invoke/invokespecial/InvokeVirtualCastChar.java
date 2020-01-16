package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeVirtualCastChar {
    public InvokeVirtualCastChar() {

    }

    @NativeObfuscation
    public boolean add(char a, char b) {
        return normalAdd(a, b) == (char) (a + b);
    }

    public char normalAdd(char a, char b) {
        return (char) (a + b);
    }
}