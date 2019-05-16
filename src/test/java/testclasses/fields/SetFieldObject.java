package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetFieldObject {
    private String fieldL;

    public SetFieldObject() {
        this.fieldL = "hello";
        this.setField("world");
    }

    public String getField() {
        return this.fieldL;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setField(String value) {
        this.fieldL = value;
    }
}
