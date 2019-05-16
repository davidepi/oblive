package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CastFloat2Long {
    public CastFloat2Long() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec(float a) {
        return (long) (a + a);
    }

}
