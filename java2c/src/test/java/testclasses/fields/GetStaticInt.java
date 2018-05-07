package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetStaticInt
{
    private static int fieldI;

    public GetStaticInt()
    {
        GetStaticInt.fieldI = 1000000;
    }

    @Obfuscation
    public int getStatic()
    {
        return GetStaticInt.fieldI;
    }
}
