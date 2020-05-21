package testclasses.exceptions.nullpointer.setfield;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionSetFieldChar {
    public ThrowNullPointerExceptionSetFieldChar() {

    }

    @NativeObfuscation
    public char exec(SupportClassChar obj) {
        obj.a = 0;
        return 0;
    }
}
