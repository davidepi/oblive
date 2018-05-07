package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetStaticFloat
{
    private static float fieldF;

    public GetStaticFloat()
    {
        GetStaticFloat.fieldF = 3.5f;
    }

    @Obfuscation
    public float getStatic()
    {
        return GetStaticFloat.fieldF;
    }
}
