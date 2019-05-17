package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class FAdd {
    public FAdd() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec(float a, float b) {
        return a + b;
    }

}