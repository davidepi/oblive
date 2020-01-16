package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionXLOADFloat {
    public ThrowNullPointerExceptionXLOADFloat() {

    }

    @NativeObfuscation
    public int exec(SupportClassFloat obj) {
        return (int) obj.b[1];
    }
}
