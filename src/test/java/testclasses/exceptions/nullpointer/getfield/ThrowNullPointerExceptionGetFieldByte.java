package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionGetFieldByte {
    public ThrowNullPointerExceptionGetFieldByte() {

    }

    @NativeObfuscation
    public byte exec(SupportClassByte obj) {
        return obj.a;
    }
}
