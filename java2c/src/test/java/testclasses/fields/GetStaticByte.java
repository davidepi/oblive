package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticByte
{
    private static byte fieldB;

    public GetStaticByte()
    {
        GetStaticByte.fieldB = 100;
    }

    @Obfuscate
    public byte getStatic()
    {
        return GetStaticByte.fieldB;
    }
}
