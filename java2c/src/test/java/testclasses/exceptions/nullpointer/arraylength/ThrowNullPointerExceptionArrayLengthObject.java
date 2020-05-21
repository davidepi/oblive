package testclasses.exceptions.nullpointer.arraylength;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class ThrowNullPointerExceptionArrayLengthObject {
    public ThrowNullPointerExceptionArrayLengthObject() {

    }

    @NativeObfuscation
    public int exec(SupportClassObject obj) {
        return obj.b.length;
    }
}
