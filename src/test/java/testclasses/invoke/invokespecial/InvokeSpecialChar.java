package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InvokeSpecialChar extends InvokeVirtualChar {
    public InvokeSpecialChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    @Override
    public char add(char a, char b) {
        return super.normalAdd(a, b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public char normalAdd(char a, char b) {
        return (char) (a - b);
    }
}