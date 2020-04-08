package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeVirtualFloat {
    public InvokeVirtualFloat() {

    }

    @NativeObfuscation
    public float add(float a, float b) {
        return normalAdd(a, b);
    }

    public float normalAdd(float a, float b) {
        int c = 1 / 0;
        return a + b;
    }
}