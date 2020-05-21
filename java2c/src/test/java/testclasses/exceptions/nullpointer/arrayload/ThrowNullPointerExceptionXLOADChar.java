package testclasses.exceptions.nullpointer.arrayload;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class ThrowNullPointerExceptionXLOADChar {
    public ThrowNullPointerExceptionXLOADChar() {

    }

    @NativeObfuscation
    public int exec(SupportClassChar obj) {
        return obj.b[1];
    }
}
