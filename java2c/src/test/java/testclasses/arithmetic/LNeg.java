package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LNeg {
    public LNeg() {

    }

    @NativeObfuscation
    public long exec(long a) {
        return -a;
    }

}
