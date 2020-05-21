package testclasses.invoke.invokespecial;

import it.oblive.annotations.NativeObfuscation;

public class InvokeSpecialCastChar extends InvokeVirtualCastChar {
    public InvokeSpecialCastChar() {

    }

    @NativeObfuscation
    @Override
    public boolean add(char a, char b) {
        return super.normalAdd(a, b) == (char) (a + b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public char normalAdd(char a, char b) {
        return (char) (a - b);
    }
}