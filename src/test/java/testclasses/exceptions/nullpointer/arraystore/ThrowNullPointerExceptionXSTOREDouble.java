package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionXSTOREDouble {
    public ThrowNullPointerExceptionXSTOREDouble() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassDouble obj) {
        obj.b[1] = 1;
        return (int) obj.b[1];
    }
}
