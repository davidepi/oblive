package testclasses.exceptions.nullpointer.arraystore;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionXSTOREByte {
    public ThrowNullPointerExceptionXSTOREByte() {

    }

    @NativeObfuscation
    public int exec(SupportClassByte obj) {
        obj.b[1] = 1;
        return obj.b[1];
    }
}
