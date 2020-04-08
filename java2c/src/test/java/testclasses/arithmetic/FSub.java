package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotations.NativeObfuscation;

public class FSub {
    public FSub() {

    }

    @NativeObfuscation
    public float exec(float a, float b) {
        return a - b;
    }

}
