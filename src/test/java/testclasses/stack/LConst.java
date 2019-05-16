package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

//LCONST_0, LCONST_1, LADD, LSTORE, LLOAD
public class LConst {
    public LConst() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long exec() {
        long a = 0;
        long b = 1;
        long c = a + b;
        return c + a;
    }
}
