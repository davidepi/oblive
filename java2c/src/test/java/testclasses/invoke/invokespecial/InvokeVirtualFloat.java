package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeVirtualFloat {
    public InvokeVirtualFloat() {

    }

    @NativeObfuscation
    public float add(float a, float b) {
        return normalAdd(a, b);
    }

    public float normalAdd(float a, float b) {
        return a + b;
    }
}