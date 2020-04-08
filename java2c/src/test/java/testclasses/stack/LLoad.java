package testclasses.stack;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class LLoad {
    public LLoad() {

    }

    @NativeObfuscation
    public long exec(long a) {
        return a;
    }
}
