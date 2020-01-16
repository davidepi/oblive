package testclasses.fields;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class SetFieldDouble {
    private double fieldD;

    public SetFieldDouble() {
        this.fieldD = 3.14159265359;
        this.setField(2.7182818284590452353602874713527);
    }

    public double getField() {
        return this.fieldD;
    }

    @NativeObfuscation
    public void setField(double value) {
        this.fieldD = value;
    }
}
