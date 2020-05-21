package testclasses.fields;

import it.oblive.annotations.NativeObfuscation;

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
