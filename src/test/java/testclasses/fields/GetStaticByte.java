package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetStaticByte {
    private static byte fieldB;

    public GetStaticByte() {
        GetStaticByte.fieldB = 100;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public byte getStatic() {
        return GetStaticByte.fieldB;
    }
}
