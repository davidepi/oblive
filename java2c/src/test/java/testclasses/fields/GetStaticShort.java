package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

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
