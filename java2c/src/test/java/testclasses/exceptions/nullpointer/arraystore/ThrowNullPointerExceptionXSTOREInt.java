package testclasses.exceptions.nullpointer.arraystore;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionXSTOREInt {
    public ThrowNullPointerExceptionXSTOREInt() {

    }

    @NativeObfuscation
    public int exec(SupportClassInt obj) {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
