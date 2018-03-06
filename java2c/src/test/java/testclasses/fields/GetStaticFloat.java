package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticFloat
{
    private static float fieldF;

    public GetStaticFloat()
    {
        GetStaticFloat.fieldF = 3.5f;
    }

    @Obfuscate
    public float getStatic()
    {
        return GetStaticFloat.fieldF;
    }
}
