package testclasses.stack;


import eu.fbk.hardening.annotation.NativeObfuscation;

public class LdcFloatInfNegative {
    public LdcFloatInfNegative() {

    }

    @NativeObfuscation
    public float exec() {
        return Float.NEGATIVE_INFINITY;
    }
}
