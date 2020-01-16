package testclasses.casts;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class CheckCastJavaType {
    public CheckCastJavaType() {

    }

    @NativeObfuscation
    public static String castString(Object a) {
        return (String) a;
    }
}
