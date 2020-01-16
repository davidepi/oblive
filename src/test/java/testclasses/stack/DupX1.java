package testclasses.stack;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class DupX1 {
    private TestingObjectDup obj;

    public DupX1() {
        this.obj = new TestingObjectDup();
    }

    @NativeObfuscation
    public int exec() {
        obj.setValue(obj.a = 2);
        return obj.a;
    }
}
