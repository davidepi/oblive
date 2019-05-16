package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetStaticShort {
    private static short fieldS;

    public GetStaticShort() {
        GetStaticShort.fieldS = 3000;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public short getStatic() {
        return GetStaticShort.fieldS;
    }
}
