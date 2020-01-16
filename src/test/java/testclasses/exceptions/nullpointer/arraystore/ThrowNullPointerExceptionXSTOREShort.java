package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionXSTOREShort {
    public ThrowNullPointerExceptionXSTOREShort() {

    }

    @NativeObfuscation
    public int exec(SupportClassShort obj) {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
