package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class DupX1 {
    private TestingObjectDup obj;

    public DupX1() {
        this.obj = new TestingObjectDup();
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec() {
        obj.setValue(obj.a = 2);
        return obj.a;
    }
}
