package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotations.NativeObfuscation;

public class DRem {
    public DRem() {

    }

    @NativeObfuscation
    public double exec(double a, double b) {
        return a % b;
    }

}
