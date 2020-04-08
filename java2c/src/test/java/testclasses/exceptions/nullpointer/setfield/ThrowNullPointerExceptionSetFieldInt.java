package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionSetFieldInt {
    public ThrowNullPointerExceptionSetFieldInt() {

    }

    @NativeObfuscation
    public int exec(SupportClassInt obj) {
        obj.a = 0;
        return 0;
    }
}
