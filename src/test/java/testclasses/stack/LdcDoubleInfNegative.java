package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LdcDoubleInfNegative {
    public LdcDoubleInfNegative() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec() {
        return Double.NEGATIVE_INFINITY;
    }
}
