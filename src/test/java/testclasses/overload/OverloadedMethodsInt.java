package testclasses.overload;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class OverloadedMethodsInt {
    public OverloadedMethodsInt() {

    }

    @NativeObfuscation
    public static int add(int a, double b) {
        return a + (int) b;
    }

    @NativeObfuscation
    public static int add(int a, int b) {
        return a + b;
    }
}
