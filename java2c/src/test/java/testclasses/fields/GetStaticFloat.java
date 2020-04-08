package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class GetStaticFloat {
    private static float fieldF;

    public GetStaticFloat() {
        GetStaticFloat.fieldF = 3.5f;
    }

    @NativeObfuscation
    public float getStatic() {
        return GetStaticFloat.fieldF;
    }
}
