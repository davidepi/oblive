package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.NativeObfuscation;

public class FNeg {
    public FNeg() {

    }

    @NativeObfuscation
    public float exec(float a) {
        return -a;
    }

}
