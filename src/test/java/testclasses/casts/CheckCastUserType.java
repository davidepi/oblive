package testclasses.casts;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.support.BaseClassEmpty;

public class CheckCastUserType {
    public CheckCastUserType() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static BaseClassEmpty castString(Object a) {
        return (BaseClassEmpty) a;
    }
}
