package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

public class GetStaticShort {
    private static short fieldS;

    public GetStaticShort() {
        GetStaticShort.fieldS = 3000;
    }

    @NativeObfuscation
    public short getStatic() {
        return GetStaticShort.fieldS;
    }
}
