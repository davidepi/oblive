package testclasses.antidebug.operators;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;

public class Pop2 {
    private boolean val;

    public Pop2() {
        this.val = false;
    }

    @NativeObfuscation
    @AntidebugSelf
    public boolean exec() {
        this.setVal();
        return this.val;
    }

    private double setVal() {
        this.val = true;
        return 1;
    }
}
