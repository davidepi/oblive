package testclasses.stack;


import eu.fbk.hardening.annotation.NativeObfuscation;

public class LdcDoubleInfPositive {
    public LdcDoubleInfPositive() {

    }

    @NativeObfuscation
    public double exec() {
        return Double.POSITIVE_INFINITY;
    }
}
