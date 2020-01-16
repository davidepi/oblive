package testclasses.conditionals;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class Goto {
    public Goto() {

    }

    @NativeObfuscation
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
