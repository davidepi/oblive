package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeSpecialChar extends InvokeVirtualChar {
    public ThrowInvokeSpecialChar() {

    }

    @NativeObfuscation
    @Override
    public char add(char a, char b) {
        return super.normalAdd(a, b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public char normalAdd(char a, char b) {
        return (char) (a - b);
    }
}
