package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import it.oblive.annotations.NativeObfuscation;

public class CastInt2Char {
    public CastInt2Char() {

    }

    @NativeObfuscation
    public char exec(int a) {
        return (char) (a + a);
    }

}
