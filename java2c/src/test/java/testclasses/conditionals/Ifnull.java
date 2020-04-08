package testclasses.conditionals;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class Ifnull {
    public Ifnull() {

    }

    @NativeObfuscation
    public boolean exec(Object value) {
        return value != null;
    }

}
