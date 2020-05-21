package testclasses.exceptions.nullpointer.arraystore;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionXSTORELong {
    public ThrowNullPointerExceptionXSTORELong() {

    }

    @NativeObfuscation
    public int exec(SupportClassLong obj) {
        obj.b[1] = 1;
        return (int) obj.b[1];
    }
}
