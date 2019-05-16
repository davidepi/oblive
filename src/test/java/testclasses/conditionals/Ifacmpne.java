package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Ifacmpne {
    public Ifacmpne() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec(Object value0, Object value1) {
        return value0 == value1;
    }

}
