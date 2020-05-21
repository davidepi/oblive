package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

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
