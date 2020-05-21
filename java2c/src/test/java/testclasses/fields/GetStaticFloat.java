package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

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
