package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import it.oblive.annotations.NativeObfuscation;

public class DMul {
    public DMul() {

    }

    @NativeObfuscation
    public double exec(double a, double b) {
        return a * b;
    }

}
