package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class IRem {
    public IRem() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(int a, int b) {
        return a % b;
    }

}
