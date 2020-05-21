package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class SetFieldObject {
    private String fieldL;

    public SetFieldObject() {
        this.fieldL = "hello";
        this.setField("world");
    }

    public String getField() {
        return this.fieldL;
    }

    @NativeObfuscation
    public void setField(String value) {
        this.fieldL = value;
    }
}
