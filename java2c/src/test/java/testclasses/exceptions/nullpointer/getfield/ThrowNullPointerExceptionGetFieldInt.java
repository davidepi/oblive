package testclasses.exceptions.nullpointer.getfield;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionGetFieldInt {
    public ThrowNullPointerExceptionGetFieldInt() {

    }

    @NativeObfuscation
    public int exec(SupportClassInt obj) {
        return obj.a;
    }
}
