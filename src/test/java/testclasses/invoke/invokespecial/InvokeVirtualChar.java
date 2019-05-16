package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeVirtualChar {
    public InvokeVirtualChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char add(char a, char b) {
        return normalAdd(a, b);
    }

    public char normalAdd(char a, char b) {
        return (char) (a + b);
    }
}