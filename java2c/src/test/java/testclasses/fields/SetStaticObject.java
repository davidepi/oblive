package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class SetStaticObject {
    private static String fieldL;

    public SetStaticObject() {
        SetStaticObject.fieldL = "hello";
        this.setStatic("world");
    }

    public String getStatic() {
        return SetStaticObject.fieldL;
    }

    @NativeObfuscation
    public void setStatic(String value) {
        SetStaticObject.fieldL = value;
    }
}
