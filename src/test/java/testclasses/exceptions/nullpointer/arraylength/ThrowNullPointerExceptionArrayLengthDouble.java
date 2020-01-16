package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionArrayLengthDouble {
    public ThrowNullPointerExceptionArrayLengthDouble() {

    }

    @NativeObfuscation
    public int exec(SupportClassDouble obj) {
        return obj.b.length;
    }
}
