package testclasses.exceptions.nullpointer.setfield;

import it.oblive.annotations.NativeObfuscation;
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
