package testclasses.stack;


import it.oblive.annotations.NativeObfuscation;

public class LdcFloatInfNegative {
    public LdcFloatInfNegative() {

    }

    @NativeObfuscation
    public float exec() {
        return Float.NEGATIVE_INFINITY;
    }
}
