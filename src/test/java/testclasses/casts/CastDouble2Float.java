package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.NativeObfuscation;

public class CastDouble2Float {
    public CastDouble2Float() {

    }

    @NativeObfuscation
    public float exec(double a) {
        return (float) (a + a);
    }

}
