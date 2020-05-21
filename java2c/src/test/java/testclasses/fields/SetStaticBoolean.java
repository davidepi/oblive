package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class SetStaticBoolean {
    private static boolean fieldZ;

    public SetStaticBoolean() {
        SetStaticBoolean.fieldZ = false;
        this.setStatic(true);
    }

    public boolean getStatic() {
        return SetStaticBoolean.fieldZ;
    }

    @NativeObfuscation
    public void setStatic(boolean value) {
        SetStaticBoolean.fieldZ = value;
    }
}
