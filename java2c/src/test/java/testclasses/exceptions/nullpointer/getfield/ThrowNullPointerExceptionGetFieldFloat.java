package testclasses.exceptions.nullpointer.getfield;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionGetFieldFloat {
    public ThrowNullPointerExceptionGetFieldFloat() {

    }

    @NativeObfuscation
    public float exec(SupportClassFloat obj) {
        return obj.a;
    }
}
