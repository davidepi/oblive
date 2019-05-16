package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionXSTORELong {
    public ThrowNullPointerExceptionXSTORELong() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassLong obj) {
        obj.b[1] = 1;
        return (int) obj.b[1];
    }
}
