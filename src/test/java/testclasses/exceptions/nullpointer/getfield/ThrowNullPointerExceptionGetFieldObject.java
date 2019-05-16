package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionGetFieldObject {
    public ThrowNullPointerExceptionGetFieldObject() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public Object exec(SupportClassObject obj) {
        return obj.a;
    }
}
