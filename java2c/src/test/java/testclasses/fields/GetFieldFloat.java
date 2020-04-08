package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class GetFieldFloat {
    private float fieldF;

    public GetFieldFloat() {
        this.fieldF = 3.5f;
    }

    @NativeObfuscation
    public float getField() {
        return this.fieldF;
    }
}
