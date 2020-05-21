package testclasses.exceptions.nullpointer.arrayload;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionXLOADBoolean {
    public ThrowNullPointerExceptionXLOADBoolean() {

    }

    @NativeObfuscation
    public int exec(SupportClassBoolean obj) {
        return obj.b[1] ? 1 : 0;
    }
}
