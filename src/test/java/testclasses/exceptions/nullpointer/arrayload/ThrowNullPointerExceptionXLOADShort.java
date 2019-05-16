package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionXLOADShort {
    public ThrowNullPointerExceptionXLOADShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassShort obj) {
        return obj.b[1];
    }
}
