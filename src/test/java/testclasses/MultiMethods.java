package testclasses;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class MultiMethods {
    public MultiMethods() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int add(int a, int b) {
        return a + b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int sub(int a, int b) {
        return a - b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int mul(int a, int b) {
        return a * b;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int div(int a, int b) {
        return a / b;
    }
}
