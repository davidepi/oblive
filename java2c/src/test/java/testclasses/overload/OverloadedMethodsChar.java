package testclasses.overload;

import it.oblive.annotations.NativeObfuscation;

public class OverloadedMethodsChar {
    public OverloadedMethodsChar() {

    }

    @NativeObfuscation
    public static int add(int a, double b) {
        return a + (int) b;
    }

    @NativeObfuscation
    public static char add(char a, char b) {
        return (char) (a + b);
    }
}
