package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionArrayLengthShort {
    public ThrowNullPointerExceptionArrayLengthShort() {

    }

    @NativeObfuscation
    public int exec(SupportClassShort obj) {
        return obj.b.length;
    }
}
