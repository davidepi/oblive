package testclasses.stack;


import it.oblive.annotations.NativeObfuscation;

public class LdcFloatNaN {
    public LdcFloatNaN() {

    }

    @NativeObfuscation
    public float exec() {
        return Float.NaN;
    }
}
