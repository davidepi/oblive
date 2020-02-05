package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.NativeObfuscation;

public class CastInt2Long {
    public CastInt2Long() {

    }

    @NativeObfuscation
    public long exec(int a) {
        return a + a;
    }

}
