package testclasses.stack;


import it.oblive.annotations.NativeObfuscation;

public class LdcDoubleNaN {
    public LdcDoubleNaN() {

    }

    @NativeObfuscation
    public double exec() {
        return Double.NaN;
    }
}
