package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeSpecialInt extends InvokeVirtualInt {
    public InvokeSpecialInt() {

    }

    @NativeObfuscation
    @Override
    public int add(int a, int b) {
        return super.normalAdd(a, b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public int normalAdd(int a, int b) {
        return a - b;
    }
}