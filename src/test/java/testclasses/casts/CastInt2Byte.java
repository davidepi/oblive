package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.NativeObfuscation;

public class CastInt2Byte {
    public CastInt2Byte() {

    }

    @NativeObfuscation
    public byte exec(int a) {
        return (byte) (a + a);
    }

}
