package testclasses.exceptions.nullpointer.arraylength;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionArrayLengthShort {
    public ThrowNullPointerExceptionArrayLengthShort() {

    }

    @NativeObfuscation
    public int exec(SupportClassShort obj) {
        return obj.b.length;
    }
}
