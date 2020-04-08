package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LAnd {
    public LAnd() {

    }

    @NativeObfuscation
    public long exec(long a, long b) {
        return a & b;
    }

}
