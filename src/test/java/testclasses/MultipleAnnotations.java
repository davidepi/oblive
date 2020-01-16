package testclasses;

import eu.fbk.hardening.annotation.Antidebug;
import eu.fbk.hardening.annotation.NativeObfuscation;

public class MultipleAnnotations {
    public MultipleAnnotations() {

    }

    @NativeObfuscation
    @Antidebug
    public static int add(int a, int b) {
        return a + b;
    }
}
