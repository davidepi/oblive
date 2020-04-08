package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionGetFieldBoolean {
    public ThrowNullPointerExceptionGetFieldBoolean() {

    }

    @NativeObfuscation
    public boolean exec(SupportClassBoolean obj) {
        return obj.a;
    }
}
