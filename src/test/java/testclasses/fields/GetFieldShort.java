package testclasses.fields;

import eu.fbk.hardening.annotation.NativeObfuscation;

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
