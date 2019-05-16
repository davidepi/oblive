package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetFieldBoolean {
    private boolean fieldZ;

    public SetFieldBoolean() {
        this.fieldZ = false;
        this.setField(true);
    }

    public boolean getField() {
        return this.fieldZ;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setField(boolean value) {
        this.fieldZ = value;
    }
}
