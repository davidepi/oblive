package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetFieldChar
{
    private char fieldC;

    public GetFieldChar()
    {
        this.fieldC = 'c';
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char getField()
    {
        return this.fieldC;
    }
}
