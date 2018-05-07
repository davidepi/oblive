package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetStaticByte
{
    private static byte fieldB;

    public GetStaticByte()
    {
        GetStaticByte.fieldB = 100;
    }

    @Obfuscation
    public byte getStatic()
    {
        return GetStaticByte.fieldB;
    }
}
