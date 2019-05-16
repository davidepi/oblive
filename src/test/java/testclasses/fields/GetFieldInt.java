package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetFieldInt {
    private int fieldI;

    public GetFieldInt() {
        this.fieldI = 1000000;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getField() {
        return this.fieldI;
    }
}
