package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionXLOADByte {
    public ThrowNullPointerExceptionXLOADByte() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassByte obj) {
        return obj.b[1];
    }
}
