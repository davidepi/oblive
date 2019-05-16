package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetStaticFloat {
    private static float fieldF;

    public SetStaticFloat() {
        SetStaticFloat.fieldF = 3.5f;
        this.setStatic(-0.5f);
    }

    public float getStatic() {
        return SetStaticFloat.fieldF;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setStatic(float value) {
        SetStaticFloat.fieldF = value;
    }
}
