package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.NativeObfuscation;

public class DNeg {
    public DNeg() {

    }

    @NativeObfuscation
    public double exec(double a) {
        return -a;
    }

}
