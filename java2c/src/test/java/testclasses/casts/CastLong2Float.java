package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotations.NativeObfuscation;

public class CastLong2Float {
    public CastLong2Float() {

    }

    @NativeObfuscation
    public float exec(long a) {
        return (float) (a + a);
    }

}
