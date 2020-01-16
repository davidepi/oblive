package testclasses.stack;


import eu.fbk.hardening.annotation.NativeObfuscation;

public class LdcFloatNaN {
    public LdcFloatNaN() {

    }

    @NativeObfuscation
    public float exec() {
        return Float.NaN;
    }
}
