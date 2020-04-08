package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionXLOADLong {
    public ThrowNullPointerExceptionXLOADLong() {

    }

    @NativeObfuscation
    public int exec(SupportClassLong obj) {
        return (int) obj.b[1];
    }
}
