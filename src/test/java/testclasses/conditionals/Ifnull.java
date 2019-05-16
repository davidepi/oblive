package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Ifnull {
    public Ifnull() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec(Object value) {
        return value != null;
    }

}
