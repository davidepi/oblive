package testclasses.stack;


import eu.fbk.hardening.annotations.NativeObfuscation;

public class LdcFloatNaN {
    public LdcFloatNaN() {

    }

    @NativeObfuscation
    public float exec() {
        return Float.NaN;
    }
}
