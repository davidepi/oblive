package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionArrayLengthShort {
    public ThrowNullPointerExceptionArrayLengthShort() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassShort obj) {
        return obj.b.length;
    }
}
