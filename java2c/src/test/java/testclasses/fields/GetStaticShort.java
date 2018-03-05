package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticShort
{
    private static short fieldS;

    public GetStaticShort()
    {
        GetStaticShort.fieldS = 3000;
    }

    @Obfuscate
    public short getStatic()
    {
        return GetStaticShort.fieldS;
    }
}
