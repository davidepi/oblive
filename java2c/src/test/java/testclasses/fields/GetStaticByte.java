package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

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
