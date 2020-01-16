package testclasses.fields;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class GetFieldObject {
    private String fieldL;

    public GetFieldObject() {
        this.fieldL = "hello world";
    }

    @NativeObfuscation
    public String getField() {
        return this.fieldL;
    }
}
