package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionArrayLengthFloat {
    public ThrowNullPointerExceptionArrayLengthFloat() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassFloat obj) {
        return obj.b.length;
    }
}
