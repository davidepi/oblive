package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionXLOADInt {
    public ThrowNullPointerExceptionXLOADInt() {

    }

    @NativeObfuscation
    public int exec(SupportClassInt obj) {
        return obj.b[1];
    }
}
