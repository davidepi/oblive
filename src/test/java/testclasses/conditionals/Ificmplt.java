package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Ificmplt {
    public Ificmplt() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec(int value) {
        return value >= 1000000000;
    }

}