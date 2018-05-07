package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetFieldChar
{
    private char fieldC;

    public GetFieldChar()
    {
        this.fieldC = 'c';
    }

    @Obfuscation
    public char getField()
    {
        return this.fieldC;
    }
}
