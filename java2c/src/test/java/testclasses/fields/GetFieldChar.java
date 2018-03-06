package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldChar
{
    private char fieldC;

    public GetFieldChar()
    {
        this.fieldC = 'c';
    }

    @Obfuscate
    public char getField()
    {
        return this.fieldC;
    }
}
