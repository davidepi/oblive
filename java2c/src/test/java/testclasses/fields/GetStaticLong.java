package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticLong
{
    private static long fieldJ;

    public GetStaticLong()
    {
        GetStaticLong.fieldJ = 10000000000L;
    }

    @Obfuscate
    public long getStatic()
    {
        return GetStaticLong.fieldJ;
    }
}
