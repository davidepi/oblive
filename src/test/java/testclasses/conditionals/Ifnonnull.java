package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Ifnonnull {
    public Ifnonnull() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec(Object value) {
        return value == null;
    }

}
