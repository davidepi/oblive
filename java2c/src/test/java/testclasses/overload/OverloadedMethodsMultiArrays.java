package testclasses.overload;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class OverloadedMethodsMultiArrays {
    public OverloadedMethodsMultiArrays() {

    }

    @NativeObfuscation
    public static int add(int a, double b) {
        return a + (int) b;
    }

    @NativeObfuscation
    public static String add(String[][] a, int[][] c) {
        return a[1][0] + c[1][0];
    }
}
