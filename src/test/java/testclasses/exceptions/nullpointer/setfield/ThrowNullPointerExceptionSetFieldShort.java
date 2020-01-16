package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionSetFieldShort {
    public ThrowNullPointerExceptionSetFieldShort() {

    }

    @NativeObfuscation
    public short exec(SupportClassShort obj) {
        obj.a = 0;
        return 0;
    }
}
