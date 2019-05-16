package testclasses.conditionals;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Goto {
    public Goto() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(int value) {
        int retval = 0;
        int a = 10;
        int decrement = 1;
        while (a > 0) {
            if (a == 1 && value == 10)
                retval = 10;
            a -= decrement;
        }
        return retval;
    }

}
