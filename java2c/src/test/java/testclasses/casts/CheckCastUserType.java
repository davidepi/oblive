package testclasses.casts;

import eu.fbk.hardening.annotations.NativeObfuscation;
import testclasses.support.BaseClassEmpty;

public class CheckCastUserType {
    public CheckCastUserType() {

    }

    @NativeObfuscation
    public static BaseClassEmpty castString(Object a) {
        return (BaseClassEmpty) a;
    }
}
