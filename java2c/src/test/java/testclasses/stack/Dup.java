package testclasses.stack;

import it.oblive.annotations.NativeObfuscation;

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
