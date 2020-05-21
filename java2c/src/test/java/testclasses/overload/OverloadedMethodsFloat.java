package testclasses.overload;

import it.oblive.annotations.NativeObfuscation;

public class OverloadedMethodsFloat {
    public OverloadedMethodsFloat() {

    }

    @NativeObfuscation
    public static int add(int a, int b) {
        return a + b;
    }

    @NativeObfuscation
    public static int add(float a, float b) {
        return (int) (a + b);
    }
}
