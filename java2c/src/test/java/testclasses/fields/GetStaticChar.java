package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetStaticChar
{
    private static char fieldC;

    public GetStaticChar()
    {
        GetStaticChar.fieldC = 'c';
    }

    @Obfuscation
    public char getStatic()
    {
        return GetStaticChar.fieldC;
    }
}
