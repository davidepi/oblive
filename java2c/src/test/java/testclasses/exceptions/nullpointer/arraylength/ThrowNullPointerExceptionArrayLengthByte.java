package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionArrayLengthByte {
    public ThrowNullPointerExceptionArrayLengthByte() {

    }

    @NativeObfuscation
    public int exec(SupportClassByte obj) {
        return obj.b.length;
    }
}
