package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CastInt2Char {
    public CastInt2Char() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char exec(int a) {
        return (char) (a + a);
    }

}