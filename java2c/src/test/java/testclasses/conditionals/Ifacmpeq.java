package testclasses.conditionals;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class Ifacmpeq {
    public Ifacmpeq() {

    }

    @NativeObfuscation
    public boolean exec(Object value0, Object value1) {
        return value0 != value1;
    }

}
