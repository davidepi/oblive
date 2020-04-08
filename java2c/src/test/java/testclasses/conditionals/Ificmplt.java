package testclasses.conditionals;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class Ificmplt {
    public Ificmplt() {

    }

    @NativeObfuscation
    public boolean exec(int value) {
        return value >= 1000000000;
    }

}
