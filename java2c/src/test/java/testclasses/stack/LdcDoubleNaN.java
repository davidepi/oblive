package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

public class LdcDoubleNaN {
    public LdcDoubleNaN() {

    }

    @NativeObfuscation
    public double exec() {
        return Double.NaN;
    }
}
