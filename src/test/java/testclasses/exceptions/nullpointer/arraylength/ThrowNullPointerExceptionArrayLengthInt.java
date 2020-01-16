package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionArrayLengthInt {
    public ThrowNullPointerExceptionArrayLengthInt() {

    }

    @NativeObfuscation
    public int exec(SupportClassInt obj) {
        return obj.b.length;
    }
}
