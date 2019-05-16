package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionArrayLengthLong {
    public ThrowNullPointerExceptionArrayLengthLong() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassLong obj) {
        return obj.b.length;
    }
}
