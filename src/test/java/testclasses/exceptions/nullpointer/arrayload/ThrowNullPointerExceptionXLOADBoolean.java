package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionXLOADBoolean {
    public ThrowNullPointerExceptionXLOADBoolean() {

    }

    @NativeObfuscation
    public int exec(SupportClassBoolean obj) {
        return obj.b[1] ? 1 : 0;
    }
}
