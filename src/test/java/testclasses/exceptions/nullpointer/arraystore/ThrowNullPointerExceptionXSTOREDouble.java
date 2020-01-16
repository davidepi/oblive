package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionXSTOREDouble {
    public ThrowNullPointerExceptionXSTOREDouble() {

    }

    @NativeObfuscation
    public int exec(SupportClassDouble obj) {
        obj.b[1] = 1;
        return (int) obj.b[1];
    }
}
