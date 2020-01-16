package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.NativeObfuscation;

public class CastDouble2Int {
    public CastDouble2Int() {

    }

    @NativeObfuscation
    public int exec(double a) {
        return (int) (a + a);
    }

}
