package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotations.NativeObfuscation;

public class CastInt2Double {
    public CastInt2Double() {

    }

    @NativeObfuscation
    public double exec(int a) {
        return a + a;
    }

}
