package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ThrowInvokeSpecialFloat extends InvokeVirtualFloat {
    public ThrowInvokeSpecialFloat() {

    }

    @NativeObfuscation
    @Override
    public float add(float a, float b) {
        return super.normalAdd(a, b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public float normalAdd(float a, float b) {
        return (a - b);
    }
}
