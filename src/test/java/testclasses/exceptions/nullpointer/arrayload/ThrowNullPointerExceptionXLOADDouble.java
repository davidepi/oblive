package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionXLOADDouble {
    public ThrowNullPointerExceptionXLOADDouble() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassDouble obj) {
        return (int) obj.b[1];
    }
}
