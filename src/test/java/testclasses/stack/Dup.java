package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Dup {
    public Dup() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        TestingObjectDup obj = new TestingObjectDup();
        ++(obj.a);
        return obj.a;
    }
}
