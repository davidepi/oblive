package testclasses.stack;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class ILoad {
    public ILoad() {

    }

    @NativeObfuscation
    public int exec(int a) {
        return a;
    }
}
