package testclasses.overload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverloadedMethodsDouble {
    public OverloadedMethodsDouble() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(int a, double b) {
        return a + (int) b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(double a, double b) {
        return (int) (a + b);
    }
}