package testclasses.exceptions.nullpointer.arrayload;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionXLOADObject {
    public ThrowNullPointerExceptionXLOADObject() {

    }

    @NativeObfuscation
    public int exec(SupportClassObject obj) {
        return obj.b[1].length();
    }
}
