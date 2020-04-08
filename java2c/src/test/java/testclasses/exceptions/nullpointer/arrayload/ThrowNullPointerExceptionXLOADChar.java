package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionXLOADChar {
    public ThrowNullPointerExceptionXLOADChar() {

    }

    @NativeObfuscation
    public int exec(SupportClassChar obj) {
        return obj.b[1];
    }
}
