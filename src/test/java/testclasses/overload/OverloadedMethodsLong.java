package testclasses.overload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverloadedMethodsLong {
    public OverloadedMethodsLong() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(int a, double b) {
        return a + (int) b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static long add(long a, int b) {
        return a + b;
    }
}
