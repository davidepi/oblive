package testclasses.stack;


import eu.fbk.hardening.annotation.NativeObfuscation;

public class LdcDoubleInfNegative {
    public LdcDoubleInfNegative() {

    }

    @NativeObfuscation
    public double exec() {
        return Double.NEGATIVE_INFINITY;
    }
}
