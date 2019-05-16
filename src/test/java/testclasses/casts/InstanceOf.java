package testclasses.casts;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class InstanceOf {
    public InstanceOf() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static boolean instanceofString(Object a) {
        return a instanceof String;
    }
}
