package testclasses.stack;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class DLoad {
    public DLoad() {

    }

    @NativeObfuscation
    public double exec(double a) {
        return a;
    }
}
