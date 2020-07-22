package testclasses.mangling;

import it.oblive.annotations.NativeObfuscation;

public class OverloadedMethodsDouble {
    public OverloadedMethodsDouble() {

    }

    @NativeObfuscation
    public static int add(int a, double b) {
        return a + (int) b;
    }

    @NativeObfuscation
    public static int add(double a, double b) {
        return (int) (a + b);
    }
}
