package testclasses.antidebug.operators;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;
import testclasses.stack.TestingObjectDup;

public class DupX1 {
    private TestingObjectDup obj;

    public DupX1() {
        this.obj = new TestingObjectDup();
    }

    @NativeObfuscation
    @AntidebugSelf
    public int exec() {
        obj.setValue(obj.a = 2);
        return obj.a;
    }
}
