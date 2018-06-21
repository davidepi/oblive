package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetStaticChar
{
    private static char fieldC;

    public GetStaticChar()
    {
        GetStaticChar.fieldC = 'c';
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char getStatic()
    {
        return GetStaticChar.fieldC;
    }
}
