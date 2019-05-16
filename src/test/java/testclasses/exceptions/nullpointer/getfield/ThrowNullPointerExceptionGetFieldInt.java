package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionGetFieldInt {
    public ThrowNullPointerExceptionGetFieldInt() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassInt obj) {
        return obj.a;
    }
}
