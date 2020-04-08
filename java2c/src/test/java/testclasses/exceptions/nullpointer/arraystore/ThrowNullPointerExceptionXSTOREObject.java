package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionXSTOREObject {
    public ThrowNullPointerExceptionXSTOREObject() {

    }

    @NativeObfuscation
    public int exec(SupportClassObject obj) {
        obj.b[1] = "str0";
        return obj.b[1].length();
    }
}
