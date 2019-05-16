package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Pop2 {
    private boolean val;

    public Pop2() {
        this.val = false;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec() {
        this.setVal();
        return this.val;
    }

    private double setVal() {
        this.val = true;
        return 1;
    }
}
