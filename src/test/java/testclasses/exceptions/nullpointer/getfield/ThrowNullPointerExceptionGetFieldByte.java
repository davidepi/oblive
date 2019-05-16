package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionGetFieldByte {
    public ThrowNullPointerExceptionGetFieldByte() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte exec(SupportClassByte obj) {
        return obj.a;
    }
}
