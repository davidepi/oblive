package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionGetFieldInt {
    public ThrowNullPointerExceptionGetFieldInt() {

    }

    @NativeObfuscation
    public int exec(SupportClassInt obj) {
        return obj.a;
    }
}
