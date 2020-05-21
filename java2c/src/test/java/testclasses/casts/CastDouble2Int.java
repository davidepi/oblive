package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import it.oblive.annotations.NativeObfuscation;

public class CastDouble2Int {
    public CastDouble2Int() {

    }

    @NativeObfuscation
    public int exec(double a) {
        return (int) (a + a);
    }

}
