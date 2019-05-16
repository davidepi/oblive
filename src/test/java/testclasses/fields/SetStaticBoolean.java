package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetStaticBoolean {
    private static boolean fieldZ;

    public SetStaticBoolean() {
        SetStaticBoolean.fieldZ = false;
        this.setStatic(true);
    }

    public boolean getStatic() {
        return SetStaticBoolean.fieldZ;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setStatic(boolean value) {
        SetStaticBoolean.fieldZ = value;
    }
}
