package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class GetFieldLong {
    private long fieldJ;

    public GetFieldLong() {
        this.fieldJ = 10000000000L;
    }

    @NativeObfuscation
    public long getField() {
        return this.fieldJ;
    }
}