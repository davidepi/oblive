package testclasses.newobj;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class NewObjectNoLdc {
    public NewObjectNoLdc() {

    }

    @NativeObfuscation
    public TestingObjectNoLdc getObject(int a, long b, double c, String d) {
        return new TestingObjectNoLdc(a, b, System.out, c, d);
    }
}
