package testclasses.casts;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InstanceOf {
    public InstanceOf() {

    }

    @NativeObfuscation
    public static boolean instanceofString(Object a) {
        return a instanceof String;
    }
}
