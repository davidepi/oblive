package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeStaticCastChar {
    public InvokeStaticCastChar() {

    }

    public static char normalAdd(char a, char b) {
        return (char) (a + b);
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(char a, char b) {
        return normalAdd(a, b) == (char) (a + b);
    }
}