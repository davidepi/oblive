package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeSpecialDouble extends InvokeVirtualDouble {
    public ThrowInvokeSpecialDouble() {

    }

    @NativeObfuscation
    @Override
    public double add(double a, double b) {
        return super.normalAdd(a, b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public double normalAdd(double a, double b) {
        return (a - b);
    }
}
