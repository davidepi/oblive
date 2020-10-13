package testclasses.antidebug.operators;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;
import testclasses.stack.TestingObjectDup;

public class Dup2X1 {
    private TestingObjectDup obj;

    public Dup2X1() {
        this.obj = new TestingObjectDup();
    }

    @NativeObfuscation
    @AntidebugSelf
    public double exec() {
        obj.setValue(obj.b = 2);
        return obj.b;
    }
}
