package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionXSTORELong {
    public ThrowNullPointerExceptionXSTORELong() {

    }

    @NativeObfuscation
    public int exec(SupportClassLong obj) {
        obj.b[1] = 1;
        return (int) obj.b[1];
    }
}
