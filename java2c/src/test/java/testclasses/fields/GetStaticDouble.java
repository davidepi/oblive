package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class GetStaticDouble {
    private static double fieldD;

    public GetStaticDouble() {
        GetStaticDouble.fieldD = 3.14159265359;
    }

    @NativeObfuscation
    public double getStatic() {
        return GetStaticDouble.fieldD;
    }
}
