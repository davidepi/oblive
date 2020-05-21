package testclasses.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

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