package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticChar {
    public InvokeStaticChar() {

    }

    public static char normalAdd(char a, char b) {
        return (char) (a + b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char add(char a, char b) {
        return normalAdd(a, b);
    }
}