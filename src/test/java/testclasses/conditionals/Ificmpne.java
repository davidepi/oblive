package testclasses.conditionals;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class Ificmpne {
    public Ificmpne() {

    }

    @NativeObfuscation
    public boolean exec(int value) {
        return value == 1000000000;
    }

}
