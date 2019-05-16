package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionXLOADFloat {
    public ThrowNullPointerExceptionXLOADFloat() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassFloat obj) {
        return (int) obj.b[1];
    }
}
