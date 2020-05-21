package testclasses.exceptions.nullpointer.arraystore;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionXSTOREChar {
    public ThrowNullPointerExceptionXSTOREChar() {

    }

    @NativeObfuscation
    public int exec(SupportClassChar obj) {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
