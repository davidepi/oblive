package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

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
