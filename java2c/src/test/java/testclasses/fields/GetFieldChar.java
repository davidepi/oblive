package testclasses.fields;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class GetFieldChar {
    private char fieldC;

    public GetFieldChar() {
        this.fieldC = 'c';
    }

    @NativeObfuscation
    public char getField() {
        return this.fieldC;
    }
}