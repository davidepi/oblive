package testclasses.invoke.invokestatic;

import eu.fbk.hardening.annotation.NativeObfuscation;

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