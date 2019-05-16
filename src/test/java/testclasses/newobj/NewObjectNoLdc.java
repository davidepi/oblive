package testclasses.newobj;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class NewObjectNoLdc {
    public NewObjectNoLdc() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public TestingObjectNoLdc getObject(int a, long b, double c, String d) {
        return new TestingObjectNoLdc(a, b, System.out, c, d);
    }
}
