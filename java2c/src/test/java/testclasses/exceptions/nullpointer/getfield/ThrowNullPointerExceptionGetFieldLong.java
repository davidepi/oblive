package testclasses.exceptions.nullpointer.getfield;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionGetFieldLong {
    public ThrowNullPointerExceptionGetFieldLong() {

    }

    @NativeObfuscation
    public long exec(SupportClassLong obj) {
        return obj.a;
    }
}
