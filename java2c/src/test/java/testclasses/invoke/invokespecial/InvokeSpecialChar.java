package testclasses.invoke.invokespecial;

import it.oblive.annotations.NativeObfuscation;

public class InvokeSpecialChar extends InvokeVirtualChar {
    public InvokeSpecialChar() {

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