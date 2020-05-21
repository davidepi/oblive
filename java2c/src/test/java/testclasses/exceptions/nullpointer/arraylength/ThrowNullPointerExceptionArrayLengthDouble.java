package testclasses.exceptions.nullpointer.arraylength;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionArrayLengthDouble {
    public ThrowNullPointerExceptionArrayLengthDouble() {

    }

    @NativeObfuscation
    public int exec(SupportClassDouble obj) {
        return obj.b.length;
    }
}
