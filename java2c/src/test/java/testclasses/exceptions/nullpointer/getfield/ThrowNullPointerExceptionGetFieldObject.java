package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionGetFieldObject {
    public ThrowNullPointerExceptionGetFieldObject() {

    }

    @NativeObfuscation
    public Object exec(SupportClassObject obj) {
        return obj.a;
    }
}
