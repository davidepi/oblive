package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionGetFieldDouble {
    public ThrowNullPointerExceptionGetFieldDouble() {

    }

    @NativeObfuscation
    public double exec(SupportClassDouble obj) {
        return obj.a;
    }
}