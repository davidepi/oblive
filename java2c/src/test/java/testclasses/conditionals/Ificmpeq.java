package testclasses.conditionals;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class Ificmpeq {
    public Ificmpeq() {

    }

    @NativeObfuscation
    public boolean exec(int value) {
        return value != 1000000000;
    }

}
