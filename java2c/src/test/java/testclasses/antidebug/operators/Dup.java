package testclasses.antidebug.operators;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;
import testclasses.stack.TestingObjectDup;

public class Dup {
    public Dup() {

    }

    @NativeObfuscation
    @AntidebugSelf
    public int exec() {
        TestingObjectDup obj = new TestingObjectDup();
        ++(obj.a);
        return obj.a;
    }
}
