package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionGetFieldChar {
    public ThrowNullPointerExceptionGetFieldChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char exec(SupportClassChar obj) {
        return obj.a;
    }
}
