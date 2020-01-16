package testclasses.stack;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class DLoad {
    public DLoad() {

    }

    @NativeObfuscation
    public double exec(double a) {
        return a;
    }
}
