package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionGetFieldShort {
    public ThrowNullPointerExceptionGetFieldShort() {

    }

    @NativeObfuscation
    public short exec(SupportClassShort obj) {
        return obj.a;
    }
}
