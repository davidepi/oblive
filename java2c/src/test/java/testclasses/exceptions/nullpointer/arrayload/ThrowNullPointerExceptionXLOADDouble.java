package testclasses.exceptions.nullpointer.arrayload;

import it.oblive.annotations.NativeObfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionXLOADDouble {
    public ThrowNullPointerExceptionXLOADDouble() {

    }

    @NativeObfuscation
    public int exec(SupportClassDouble obj) {
        return (int) obj.b[1];
    }
}
