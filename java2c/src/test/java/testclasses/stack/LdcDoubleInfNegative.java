package testclasses.stack;


import it.oblive.annotations.NativeObfuscation;

public class LdcDoubleInfNegative {
    public LdcDoubleInfNegative() {

    }

    @NativeObfuscation
    public double exec() {
        return Double.NEGATIVE_INFINITY;
    }
}
