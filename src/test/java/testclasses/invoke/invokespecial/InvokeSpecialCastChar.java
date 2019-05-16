package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeSpecialCastChar extends InvokeVirtualCastChar {
    public InvokeSpecialCastChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    @Override
    public boolean add(char a, char b) {
        return super.normalAdd(a, b) == (char) (a + b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public char normalAdd(char a, char b) {
        return (char) (a - b);
    }
}