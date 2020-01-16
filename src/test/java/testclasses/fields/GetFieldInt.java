package testclasses.fields;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class GetFieldInt {
    private int fieldI;

    public GetFieldInt() {
        this.fieldI = 1000000;
    }

    @NativeObfuscation
    public int getField() {
        return this.fieldI;
    }
}
