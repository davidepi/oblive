package testclasses.overload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class OverloadedMethodsFloat {
    public OverloadedMethodsFloat() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(int a, int b) {
        return a + b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static int add(float a, float b) {
        return (int) (a + b);
    }
}
