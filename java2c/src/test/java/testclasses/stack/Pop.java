package testclasses.stack;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class Pop {
    private boolean val;

    public Pop() {
        this.val = false;
    }

    @NativeObfuscation
    public boolean exec() {
        this.setVal();
        return this.val;
    }

    private float setVal() {
        this.val = true;
        return 1.f;
    }
}
