package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeSpecialFloat extends InvokeVirtualFloat {
    public InvokeSpecialFloat() {

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