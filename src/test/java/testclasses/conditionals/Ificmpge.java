package testclasses.conditionals;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class Ificmpge {
    public Ificmpge() {

    }

    @NativeObfuscation
    public boolean exec(int value) {
        return value < 1000000000;
    }

}
