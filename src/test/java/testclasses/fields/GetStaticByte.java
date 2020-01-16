package testclasses.fields;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class GetStaticByte {
    private static byte fieldB;

    public GetStaticByte() {
        GetStaticByte.fieldB = 100;
    }

    @NativeObfuscation
    public byte getStatic() {
        return GetStaticByte.fieldB;
    }
}
