package testclasses.conditionals;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class Ifnonnull {
    public Ifnonnull() {

    }

    @NativeObfuscation
    public boolean exec(Object value) {
        return value == null;
    }

}