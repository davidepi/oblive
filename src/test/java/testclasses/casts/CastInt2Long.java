package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CastInt2Long {
    public CastInt2Long() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec(int a) {
        return (long) (a + a);
    }

}
