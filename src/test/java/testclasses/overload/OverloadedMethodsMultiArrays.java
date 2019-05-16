package testclasses.overload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverloadedMethodsMultiArrays {
    public OverloadedMethodsMultiArrays() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(int a, double b) {
        return a + (int) b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static String add(String[][] a, int[][] c) {
        return a[1][0] + c[1][0];
    }
}
