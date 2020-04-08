package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class GetStaticBoolean {
    private static boolean fieldZ;

    public GetStaticBoolean() {
        GetStaticBoolean.fieldZ = true;
    }

    @NativeObfuscation
    public boolean getStatic() {
        return GetStaticBoolean.fieldZ;
    }
}