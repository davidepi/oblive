package testclasses.stack;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class LLoad {
    public LLoad() {

    }

    @NativeObfuscation
    public long exec(long a) {
        return a;
    }
}
