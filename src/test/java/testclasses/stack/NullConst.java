package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

//BIPUSH
public class NullConst {
    public NullConst() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public Object exec() {
        return null;
    }
}
