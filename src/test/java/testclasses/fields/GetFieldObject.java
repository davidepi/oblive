package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetFieldObject {
    private String fieldL;

    public GetFieldObject() {
        this.fieldL = "hello world";
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String getField() {
        return this.fieldL;
    }
}
