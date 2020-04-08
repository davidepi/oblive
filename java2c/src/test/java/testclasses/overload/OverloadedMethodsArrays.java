package testclasses.overload;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class OverloadedMethodsArrays {
    public OverloadedMethodsArrays() {

    }

    @NativeObfuscation
    public static int add(int a, double b) {
        return a + (int) b;
    }

    @NativeObfuscation
    public static String add(String[] a, int[] c) {
        return a[0] + c[0];
    }
}
