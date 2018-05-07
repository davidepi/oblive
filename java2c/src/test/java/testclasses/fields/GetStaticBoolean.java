package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetStaticBoolean
{
    private static boolean fieldZ;

    public GetStaticBoolean()
    {
        GetStaticBoolean.fieldZ = true;
    }

    @Obfuscation
    public boolean getStatic()
    {
        return GetStaticBoolean.fieldZ;
    }
}
