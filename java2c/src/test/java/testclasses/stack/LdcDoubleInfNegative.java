package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

public class LdcDoubleInfNegative {
    public LdcDoubleInfNegative() {

    }

    @NativeObfuscation
    public double exec() {
        return Double.NEGATIVE_INFINITY;
    }
}
