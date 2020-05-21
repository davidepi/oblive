package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class GetStaticObject {
    private static String fieldL;

    public GetStaticObject() {
        GetStaticObject.fieldL = "hello world";
    }

    @NativeObfuscation
    public String getStatic() {
        return GetStaticObject.fieldL;
    }
}
