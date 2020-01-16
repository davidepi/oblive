package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionXLOADShort {
    public ThrowNullPointerExceptionXLOADShort() {

    }

    @NativeObfuscation
    public int exec(SupportClassShort obj) {
        return obj.b[1];
    }
}
