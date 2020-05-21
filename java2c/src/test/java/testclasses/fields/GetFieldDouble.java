package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class GetFieldDouble {
    private double fieldD;

    public GetFieldDouble() {
        this.fieldD = 3.14159265359;
    }

    @NativeObfuscation
    public double getField() {
        return this.fieldD;
    }
}
