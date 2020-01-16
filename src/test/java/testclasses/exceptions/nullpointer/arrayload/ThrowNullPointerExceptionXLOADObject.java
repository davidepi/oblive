package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionXLOADObject {
    public ThrowNullPointerExceptionXLOADObject() {

    }

    @NativeObfuscation
    public int exec(SupportClassObject obj) {
        return obj.b[1].length();
    }
}
