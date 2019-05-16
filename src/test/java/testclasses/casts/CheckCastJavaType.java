package testclasses.casts;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CheckCastJavaType {
    public CheckCastJavaType() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static String castString(Object a) {
        return (String) a;
    }
}
