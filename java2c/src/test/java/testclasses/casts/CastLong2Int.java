package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import it.oblive.annotations.NativeObfuscation;

public class CastLong2Int {
    public CastLong2Int() {

    }

    @NativeObfuscation
    public int exec(long a) {
        return (int) (a + a);
    }

}
