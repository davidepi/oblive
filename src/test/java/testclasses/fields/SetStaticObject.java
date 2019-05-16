package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetStaticObject {
    private static String fieldL;

    public SetStaticObject() {
        SetStaticObject.fieldL = "hello";
        this.setStatic("world");
    }

    public String getStatic() {
        return SetStaticObject.fieldL;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setStatic(String value) {
        SetStaticObject.fieldL = value;
    }
}
