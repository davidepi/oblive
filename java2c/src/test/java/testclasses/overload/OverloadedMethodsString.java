package testclasses.overload;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class OverloadedMethodsString {
    public OverloadedMethodsString() {

    }

    @NativeObfuscation
    public static int add(int a, double b) {
        return a + (int) b;
    }

    @NativeObfuscation
    public static String add(String a, String b, int c) {
        return a + c + b;
    }
}
