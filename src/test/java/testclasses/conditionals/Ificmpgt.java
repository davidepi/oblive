package testclasses.conditionals;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class Ificmpgt {
    public Ificmpgt() {

    }

    @NativeObfuscation
    public boolean exec(int value) {
        return value <= 1000000000;
    }

}
