package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetFieldLong {
    private long fieldJ;

    public GetFieldLong() {
        this.fieldJ = 10000000000L;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long getField() {
        return this.fieldJ;
    }
}
