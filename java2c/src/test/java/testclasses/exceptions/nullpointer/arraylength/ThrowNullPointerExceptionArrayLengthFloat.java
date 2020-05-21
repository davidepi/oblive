package testclasses.exceptions.nullpointer.arraylength;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionArrayLengthFloat {
    public ThrowNullPointerExceptionArrayLengthFloat() {

    }

    @NativeObfuscation
    public int exec(SupportClassFloat obj) {
        return obj.b.length;
    }
}
