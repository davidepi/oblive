package testclasses.exceptions.nullpointer.setfield;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionSetFieldFloat {
    public ThrowNullPointerExceptionSetFieldFloat() {

    }

    @NativeObfuscation
    public float exec(SupportClassFloat obj) {
        obj.a = 0;
        return 0;
    }
}
