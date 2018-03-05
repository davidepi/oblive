package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticChar
{
    private static char fieldC;

    public GetStaticChar()
    {
        GetStaticChar.fieldC = 'c';
    }

    @Obfuscate
    public char getStatic()
    {
        return GetStaticChar.fieldC;
    }
}
