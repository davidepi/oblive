package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class SetStaticFloat {
    private static float fieldF;

    public SetStaticFloat() {
        SetStaticFloat.fieldF = 3.5f;
        this.setStatic(-0.5f);
    }

    public float getStatic() {
        return SetStaticFloat.fieldF;
    }

    @NativeObfuscation
    public void setStatic(float value) {
        SetStaticFloat.fieldF = value;
    }
}
