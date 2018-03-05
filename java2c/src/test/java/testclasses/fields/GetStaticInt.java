package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticInt
{
    private static int fieldI;

    public GetStaticInt()
    {
        GetStaticInt.fieldI = 1000000;
    }

    @Obfuscate
    public int getStatic()
    {
        return GetStaticInt.fieldI;
    }
}
