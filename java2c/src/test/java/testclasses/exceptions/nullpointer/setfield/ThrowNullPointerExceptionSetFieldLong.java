package testclasses.exceptions.nullpointer.setfield;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionSetFieldLong {
    public ThrowNullPointerExceptionSetFieldLong() {

    }

    @NativeObfuscation
    public long exec(SupportClassLong obj) {
        obj.a = 0;
        return 0;
    }
}
