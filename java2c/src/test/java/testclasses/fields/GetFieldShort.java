package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class GetFieldShort {
    private short fieldS;

    public GetFieldShort() {
        this.fieldS = 3000;
    }

    @NativeObfuscation
    public short getField() {
        return this.fieldS;
    }
}
