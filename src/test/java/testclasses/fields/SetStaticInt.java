package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetStaticInt {
    private static int fieldI;

    public SetStaticInt() {
        SetStaticInt.fieldI = 1000000;
        this.setStatic(-1000000);
    }

    public int getStatic() {
        return SetStaticInt.fieldI;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setStatic(int value) {
        SetStaticInt.fieldI = value;
    }
}
