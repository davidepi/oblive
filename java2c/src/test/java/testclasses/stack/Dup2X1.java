package testclasses.stack;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class Dup2X1 {
    private TestingObjectDup obj;

    public Dup2X1() {
        this.obj = new TestingObjectDup();
    }

    @NativeObfuscation
    public double exec() {
        obj.setValue(obj.b = 2);
        return obj.b;
    }
}
