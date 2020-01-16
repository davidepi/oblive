package testclasses.fields;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class GetStaticChar {
    private static char fieldC;

    public GetStaticChar() {
        GetStaticChar.fieldC = 'c';
    }

    @NativeObfuscation
    public char getStatic() {
        return GetStaticChar.fieldC;
    }
}
