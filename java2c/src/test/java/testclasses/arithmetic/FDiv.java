package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import it.oblive.annotations.NativeObfuscation;

public class FDiv {
    public FDiv() {

    }

    @NativeObfuscation
    public float exec(float a, float b) {
        return a / b;
    }

}
