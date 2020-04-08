package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

public class LdcFloatInfNegative {
    public LdcFloatInfNegative() {

    }

    @NativeObfuscation
    public float exec() {
        return Float.NEGATIVE_INFINITY;
    }
}
