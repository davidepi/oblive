package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetStaticShort
{
    private static short fieldS;

    public GetStaticShort()
    {
        GetStaticShort.fieldS = 3000;
    }

    @Obfuscation
    public short getStatic()
    {
        return GetStaticShort.fieldS;
    }
}
