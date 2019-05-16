package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

//SIPUSH
public class SConst {
    public SConst() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        short a = -3000;
        short b = 12000;
        return a + b;
    }
}
