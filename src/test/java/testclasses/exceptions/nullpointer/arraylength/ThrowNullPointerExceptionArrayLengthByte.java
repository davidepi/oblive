package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionArrayLengthByte {
    public ThrowNullPointerExceptionArrayLengthByte() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassByte obj) {
        return obj.b.length;
    }
}
