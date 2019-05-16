package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionXLOADLong {
    public ThrowNullPointerExceptionXLOADLong() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassLong obj) {
        return (int) obj.b[1];
    }
}
