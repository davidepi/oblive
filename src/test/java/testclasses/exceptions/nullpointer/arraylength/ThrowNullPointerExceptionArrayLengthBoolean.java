package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionArrayLengthBoolean {
    public ThrowNullPointerExceptionArrayLengthBoolean() {

    }

    @NativeObfuscation
    public int exec(SupportClassBoolean obj) {
        return obj.b.length;
    }
}
