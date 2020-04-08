package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class SetStaticInt {
    private static int fieldI;

    public SetStaticInt() {
        SetStaticInt.fieldI = 1000000;
        this.setStatic(-1000000);
    }

    public int getStatic() {
        return SetStaticInt.fieldI;
    }

    @NativeObfuscation
    public void setStatic(int value) {
        SetStaticInt.fieldI = value;
    }
}
