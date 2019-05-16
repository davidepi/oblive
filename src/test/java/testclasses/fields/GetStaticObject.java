package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetStaticObject {
    private static String fieldL;

    public GetStaticObject() {
        GetStaticObject.fieldL = "hello world";
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String getStatic() {
        return GetStaticObject.fieldL;
    }
}
