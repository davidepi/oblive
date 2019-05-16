package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class DLoad {
    public DLoad() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec(double a) {
        return a;
    }
}
