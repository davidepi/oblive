package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

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
