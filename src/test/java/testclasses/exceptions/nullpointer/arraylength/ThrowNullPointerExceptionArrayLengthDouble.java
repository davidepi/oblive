package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionArrayLengthDouble {
    public ThrowNullPointerExceptionArrayLengthDouble() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassDouble obj) {
        return obj.b.length;
    }
}
