package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class GetStaticBoolean
{
    private static boolean fieldZ;

    public GetStaticBoolean()
    {
        GetStaticBoolean.fieldZ = true;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean getStatic()
    {
        return GetStaticBoolean.fieldZ;
    }
}
