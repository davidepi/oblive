package testclasses.invoke.invokestatic;

import it.oblive.annotations.NativeObfuscation;

public class InvokeStaticFloat {
    public InvokeStaticFloat() {

    }

    public static float normalAdd(float a, float b) {
        return a + b;
    }

    @NativeObfuscation
    public float add(float a, float b) {
        return normalAdd(a, b);
    }
}