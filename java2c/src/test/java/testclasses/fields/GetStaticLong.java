package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetStaticLong
{
    private static long fieldJ;

    public GetStaticLong()
    {
        GetStaticLong.fieldJ = 10000000000L;
    }

    @Obfuscation
    public long getStatic()
    {
        return GetStaticLong.fieldJ;
    }
}
