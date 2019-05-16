package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionXSTOREByte {
    public ThrowNullPointerExceptionXSTOREByte() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassByte obj) {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
