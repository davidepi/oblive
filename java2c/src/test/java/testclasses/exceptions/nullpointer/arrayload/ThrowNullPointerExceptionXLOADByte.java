package testclasses.exceptions.nullpointer.arrayload;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassByte;

public class ThrowNullPointerExceptionXLOADByte {
    public ThrowNullPointerExceptionXLOADByte() {

    }

    @NativeObfuscation
    public int exec(SupportClassByte obj) {
        return obj.b[1];
    }
}
