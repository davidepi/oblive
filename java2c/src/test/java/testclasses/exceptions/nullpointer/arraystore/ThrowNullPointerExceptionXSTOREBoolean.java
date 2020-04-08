package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionXSTOREBoolean {
    public ThrowNullPointerExceptionXSTOREBoolean() {

    }

    @NativeObfuscation
    public int exec(SupportClassBoolean obj) {
        obj.b[1] = true;
        return obj.b[1] ? 1 : 0;
    }
}
