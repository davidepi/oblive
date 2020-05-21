package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import it.oblive.annotations.NativeObfuscation;

public class CastFloat2Int {
    public CastFloat2Int() {

    }

    @NativeObfuscation
    public int exec(float a) {
        return (int) (a + a);
    }

}
