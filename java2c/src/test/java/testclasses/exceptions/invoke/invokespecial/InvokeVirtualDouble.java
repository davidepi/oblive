package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class InvokeVirtualDouble {
    public InvokeVirtualDouble() {

    }

    @NativeObfuscation
    public double add(double a, double b) {
        return normalAdd(a, b);
    }

    public double normalAdd(double a, double b) {
        int c = 1 / 0;
        return a + b;
    }
}