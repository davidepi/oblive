package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import it.oblive.annotations.NativeObfuscation;

public class CastInt2Float {
    public CastInt2Float() {

    }

    @NativeObfuscation
    public float exec(int a) {
        return (float) (a + a);
    }

}
