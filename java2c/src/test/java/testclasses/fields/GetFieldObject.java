package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

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
