package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionSetFieldBoolean {
    public ThrowNullPointerExceptionSetFieldBoolean() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec(SupportClassBoolean obj) {
        obj.a = false;
        return true;
    }
}
