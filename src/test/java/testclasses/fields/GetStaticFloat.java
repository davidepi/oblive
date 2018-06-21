package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetStaticFloat
{
    private static float fieldF;

    public GetStaticFloat()
    {
        GetStaticFloat.fieldF = 3.5f;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float getStatic()
    {
        return GetStaticFloat.fieldF;
    }
}
