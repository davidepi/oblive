package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionXLOADByte {
    public ThrowNullPointerExceptionXLOADByte() {

    }

    @NativeObfuscation
    public int exec(SupportClassByte obj) {
        return obj.b[1];
    }
}
