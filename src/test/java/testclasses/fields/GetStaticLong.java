package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetStaticLong
{
    private static long fieldJ;

    public GetStaticLong()
    {
        GetStaticLong.fieldJ = 10000000000L;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long getStatic()
    {
        return GetStaticLong.fieldJ;
    }
}
