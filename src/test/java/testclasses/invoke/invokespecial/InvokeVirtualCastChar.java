package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualCastChar {
    public InvokeVirtualCastChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(char a, char b) {
        return normalAdd(a, b) == (char) (a + b);
    }

    public char normalAdd(char a, char b) {
        return (char) (a + b);
    }
}