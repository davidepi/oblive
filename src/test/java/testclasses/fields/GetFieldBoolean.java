package testclasses.fields;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class GetFieldBoolean {
    private boolean fieldZ;

    public GetFieldBoolean() {
        this.fieldZ = true;
    }

    @NativeObfuscation
    public boolean getField() {
        return this.fieldZ;
    }
}
