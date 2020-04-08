package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class SetFieldBoolean {
    private boolean fieldZ;

    public SetFieldBoolean() {
        this.fieldZ = false;
        this.setField(true);
    }

    public boolean getField() {
        return this.fieldZ;
    }

    @NativeObfuscation
    public void setField(boolean value) {
        this.fieldZ = value;
    }
}
