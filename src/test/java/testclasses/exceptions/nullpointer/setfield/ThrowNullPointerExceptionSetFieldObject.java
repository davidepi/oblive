package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionSetFieldObject {
    public ThrowNullPointerExceptionSetFieldObject() {

    }

    @NativeObfuscation
    public Object exec(SupportClassObject obj) {
        obj.a = "a";
        return obj;
    }
}
