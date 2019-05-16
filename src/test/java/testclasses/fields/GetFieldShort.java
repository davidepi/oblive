package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetFieldShort {
    private short fieldS;

    public GetFieldShort() {
        this.fieldS = 3000;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short getField() {
        return this.fieldS;
    }
}
