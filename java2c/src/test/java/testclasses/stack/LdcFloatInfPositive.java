package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

public class LdcFloatInfPositive {
    public LdcFloatInfPositive() {

    }

    @NativeObfuscation
    public float exec() {
        return Float.POSITIVE_INFINITY;
    }
}
