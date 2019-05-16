package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionArrayLengthChar {
    public ThrowNullPointerExceptionArrayLengthChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassChar obj) {
        return obj.b.length;
    }
}
