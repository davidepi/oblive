package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticShort
{
    private static int fieldS;

    public GetStaticShort()
    {
        GetStaticShort.fieldS = 3000;
    }

    @Obfuscate
    public int getStatic()
    {
        return GetStaticShort.fieldS;
    }
}
