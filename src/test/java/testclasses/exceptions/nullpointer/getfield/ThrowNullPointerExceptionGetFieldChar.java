package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionGetFieldChar {
    public ThrowNullPointerExceptionGetFieldChar() {

    }

    @NativeObfuscation
    public char exec(SupportClassChar obj) {
        return obj.a;
    }
}
