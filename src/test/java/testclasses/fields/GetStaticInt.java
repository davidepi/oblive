package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetStaticInt {
    private static int fieldI;

    public GetStaticInt() {
        GetStaticInt.fieldI = 1000000;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getStatic() {
        return GetStaticInt.fieldI;
    }
}
