package testclasses.stack;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class Dup {
    public Dup() {

    }

    @NativeObfuscation
    public int exec() {
        TestingObjectDup obj = new TestingObjectDup();
        ++(obj.a);
        return obj.a;
    }
}
