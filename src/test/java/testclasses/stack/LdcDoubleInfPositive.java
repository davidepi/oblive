package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LdcDoubleInfPositive {
    public LdcDoubleInfPositive() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec() {
        return Double.POSITIVE_INFINITY;
    }
}
