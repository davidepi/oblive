package testclasses.invoke.invokespecial;

import it.oblive.annotations.NativeObfuscation;

public class InvokeSpecialCastShort extends InvokeVirtualCastShort {
    public InvokeSpecialCastShort() {

    }

    @NativeObfuscation
    @Override
    public boolean add(short a, short b) {
        return super.normalAdd(a, b) == (short) (a + b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public short normalAdd(short a, short b) {
        return (short) (a - b);
    }
}