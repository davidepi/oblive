package testclasses.exceptions.nullpointer.setfield;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionSetFieldBoolean {
    public ThrowNullPointerExceptionSetFieldBoolean() {

    }

    @NativeObfuscation
    public boolean exec(SupportClassBoolean obj) {
        obj.a = false;
        return true;
    }
}
