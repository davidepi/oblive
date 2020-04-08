package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotations.NativeObfuscation;

public class CastLong2Double {
    public CastLong2Double() {

    }

    @NativeObfuscation
    public double exec(long a) {
        return (double) (a + a);
    }

}
