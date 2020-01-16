package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionGetFieldInt {
    public ThrowNullPointerExceptionGetFieldInt() {

    }

    @NativeObfuscation
    public int exec(SupportClassInt obj) {
        return obj.a;
    }
}
