package testclasses.stack;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class FLoad {
    public FLoad() {

    }

    @NativeObfuscation
    public float exec(float a) {
        return a;
    }
}
