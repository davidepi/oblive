package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionXSTOREFloat {
    public ThrowNullPointerExceptionXSTOREFloat() {

    }

    @NativeObfuscation
    public int exec(SupportClassFloat obj) {
        obj.b[1] = 1;
        return (int) obj.b[1];
    }
}
