package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LdcFloatInfPositive {
    public LdcFloatInfPositive() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float exec() {
        return Float.POSITIVE_INFINITY;
    }
}
