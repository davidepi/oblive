package testclasses.exceptions.nullpointer.arraylength;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionArrayLengthLong {
    public ThrowNullPointerExceptionArrayLengthLong() {

    }

    @NativeObfuscation
    public int exec(SupportClassLong obj) {
        return obj.b.length;
    }
}
