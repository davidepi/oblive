package testclasses.stack;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class ALoad {
    public ALoad() {

    }

    @NativeObfuscation
    public String exec(String a) {
        return a;
    }
}
