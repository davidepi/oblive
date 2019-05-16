package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

//BIPUSH
public class BConst {
    public BConst() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        byte a = -30;
        byte b = 120;
        return a + b;
    }
}
