package testclasses;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class MultiMethods {
    public MultiMethods() {

    }

    @NativeObfuscation
    public int add(int a, int b) {
        return a + b;
    }

    @NativeObfuscation
    public int sub(int a, int b) {
        return a - b;
    }

    @NativeObfuscation
    public int mul(int a, int b) {
        return a * b;
    }

    @NativeObfuscation
    public int div(int a, int b) {
        return a / b;
    }
}
