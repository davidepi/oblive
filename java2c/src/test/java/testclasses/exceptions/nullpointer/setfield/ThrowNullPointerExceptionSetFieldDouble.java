package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionSetFieldDouble {
    public ThrowNullPointerExceptionSetFieldDouble() {

    }

    @NativeObfuscation
    public double exec(SupportClassDouble obj) {
        obj.a = 0;
        return 0;
    }
}
